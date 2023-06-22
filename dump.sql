create table academic_title
(
    id   int unsigned auto_increment
        primary key,
    name varchar(32) not null
);

create table control_event_type
(
    id   int unsigned auto_increment
        primary key,
    name varchar(32) not null
);

create table discipline
(
    id   int unsigned auto_increment
        primary key,
    name varchar(64) null
);

create table faculty
(
    id          int unsigned auto_increment
        primary key,
    name        varchar(32)  not null,
    DESCRIPTION varchar(128) null
);

create table department
(
    id          int unsigned auto_increment
        primary key,
    faculty_id  int unsigned not null,
    name        varchar(32)  not null,
    description varchar(64)  not null,
    constraint department_faculty_fk
        foreign key (faculty_id) references faculty (id)
);

create table grade
(
    id                 int unsigned auto_increment
        primary key,
    name               varchar(32) not null,
    weight_coefficient float       not null
);

create table grade_control_event_type
(
    id                    int unsigned auto_increment
        primary key,
    grade_id              int unsigned not null,
    control_event_type_id int unsigned not null,
    constraint event_type_fk
        foreign key (control_event_type_id) references control_event_type (id),
    constraint grade_fk
        foreign key (grade_id) references grade (id)
);

create table lecturer
(
    id                int unsigned auto_increment
        primary key,
    department_id     int unsigned not null,
    academic_title_id int unsigned not null,
    name              varchar(32)  not null,
    surname           varchar(32)  not null,
    patronymic        varchar(32)  null,
    constraint lecturer_academic_title_fk
        foreign key (academic_title_id) references academic_title (id),
    constraint lecturer_department_fk
        foreign key (department_id) references department (id)
);

create table discipline_lecturer
(
    id            int unsigned auto_increment
        primary key,
    lecturer_id   int unsigned not null,
    discipline_id int unsigned not null,
    constraint dl_unique
        unique (lecturer_id, discipline_id),
    constraint discipline_lecturer_discipline_fk
        foreign key (discipline_id) references discipline (id),
    constraint discipline_lecturer_lecturer_fk
        foreign key (lecturer_id) references lecturer (id)
);

create table control_event_variant
(
    id                     int unsigned auto_increment
        primary key,
    discipline_lecturer_id int unsigned not null,
    variant_num            int unsigned not null,
    constraint discipline_lecturer_fk
        foreign key (discipline_lecturer_id) references discipline_lecturer (id)
);

create table location
(
    id   int unsigned auto_increment
        primary key,
    name varchar(64) not null
);

create table location_auditory
(
    id              int unsigned auto_increment
        primary key,
    location_id     int unsigned not null,
    auditory_number int          not null,
    constraint la_unique
        unique (location_id, auditory_number),
    constraint location_auditory_fk
        foreign key (location_id) references location (id)
);

create table study_group_base
(
    id            int unsigned auto_increment
        primary key,
    department_id int unsigned not null,
    name          varchar(32)  not null,
    description   varchar(64)  not null,
    constraint study_group_base_department_fk
        foreign key (department_id) references department (id)
);

create table study_group_postfix
(
    id           int unsigned auto_increment
        primary key,
    postfix_name varchar(4) not null,
    constraint postfix_name_unique
        unique (postfix_name)
);

create table study_group
(
    id                     int unsigned auto_increment
        primary key,
    study_group_postfix_id int unsigned not null,
    study_group_base_id    int unsigned not null,
    admission_year         int unsigned not null,
    group_num              int unsigned not null,
    constraint study_group_study_group_base_fk
        foreign key (study_group_base_id) references study_group_base (id),
    constraint study_group_study_group_postfix_fk
        foreign key (study_group_postfix_id) references study_group_postfix (id),
    constraint admission_year_check
        check (`admission_year` < 100)
);

create table discipline_lecturer_study_group
(
    id                     int unsigned auto_increment
        primary key,
    discipline_lecturer_id int unsigned not null,
    study_group_id         int unsigned not null,
    constraint dlsg_unique
        unique (discipline_lecturer_id, study_group_id),
    constraint discipline_lecturer_study_group_discipline_lecturer_fk
        foreign key (discipline_lecturer_id) references discipline_lecturer (id),
    constraint discipline_lecturer_study_group_study_group_fk
        foreign key (study_group_id) references study_group (id)
);

create table control_event
(
    id                                 int unsigned auto_increment
        primary key,
    control_event_type_id              int unsigned not null,
    control_event_auditory_id          int unsigned not null,
    start_date                         datetime     not null,
    discipline_lecturer_study_group_id int unsigned not null,
    constraint ce_unique
        unique (control_event_type_id, control_event_auditory_id, discipline_lecturer_study_group_id, start_date),
    constraint control_event_auditory_fk
        foreign key (control_event_auditory_id) references location_auditory (id),
    constraint control_event_control_event_type_fk
        foreign key (control_event_type_id) references control_event_type (id),
    constraint control_event_discipline_lecturer_study_group_fk
        foreign key (discipline_lecturer_study_group_id) references discipline_lecturer_study_group (id)
);

create table student
(
    id             int unsigned auto_increment
        primary key,
    study_group_id int unsigned not null,
    name           varchar(32)  not null,
    surname        varchar(32)  not null,
    patronymic     varchar(32)  null,
    constraint student_study_group_fk
        foreign key (study_group_id) references study_group (id)
);

create table control_event_result
(
    id                       int unsigned auto_increment
        primary key,
    student_id               int unsigned not null,
    control_event_id         int unsigned not null,
    control_event_variant_id int unsigned not null,
    grade_id                 int unsigned not null,
    constraint control_event_result_unique
        unique (student_id, control_event_id),
    constraint control_event_grade_fk
        foreign key (grade_id) references grade (id),
    constraint control_event_result_control_event_fk
        foreign key (control_event_id) references control_event (id),
    constraint control_event_result_control_event_variant_fk
        foreign key (control_event_variant_id) references control_event_variant (id),
    constraint control_event_result_student_fk
        foreign key (student_id) references student (id)
);

create definer = root@localhost trigger grade_control_event_check
    before insert
    on control_event_result
    for each row
BEGIN
        IF (NOT control_event_validation(new.control_event_id,new.grade_id)) THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'TriggerError: An attempt to match an invalid grade and control event type.';
        end if;
    end;

create definer = root@localhost trigger student_control_event_check
    before insert
    on control_event_result
    for each row
BEGIN
        DECLARE new_student_id INT UNSIGNED;
        DECLARE new_student_group_id INT UNSIGNED;
        DECLARE dlsg_id INT UNSIGNED;
        DECLARE control_event_group_id INT UNSIGNED;

        SET new_student_id = new.student_id;

        SELECT control_event.discipline_lecturer_study_group_id  INTO dlsg_id FROM control_event WHERE control_event.id = new.control_event_id;
        SELECT discipline_lecturer_study_group.study_group_id INTO control_event_group_id FROM discipline_lecturer_study_group WHERE discipline_lecturer_study_group.id=dlsg_id;
        SELECT student.study_group_id INTO new_student_group_id FROM student WHERE student.id = new_student_id;

        IF (new_student_group_id != control_event_group_id) THEN
             SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT =
                'TriggerError: Invalid student.';
        end if;

    end;

create definer = root@localhost trigger variant_control_event_check
    before insert
    on control_event_result
    for each row
BEGIN
    DECLARE control_event_variant_discipline_lecturer_id INT UNSIGNED;
    DECLARE control_event_discipline_lecturer_study_group_id INT UNSIGNED;
    DECLARE control_event_discipline_lecturer_id INT UNSIGNED;

    SELECT control_event_variant.discipline_lecturer_id
    INTO control_event_variant_discipline_lecturer_id
    FROM control_event_variant
    WHERE new.control_event_variant_id = control_event_variant.id;

    SELECT control_event.discipline_lecturer_study_group_id
    INTO control_event_discipline_lecturer_study_group_id
    FROM control_event
    WHERE control_event.id = new.control_event_id;

    SELECT discipline_lecturer_study_group.discipline_lecturer_id
    INTO control_event_discipline_lecturer_id
    FROM discipline_lecturer_study_group
    WHERE discipline_lecturer_study_group.id=control_event_discipline_lecturer_study_group_id;

    IF control_event_discipline_lecturer_id != control_event_variant_discipline_lecturer_id THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'TriggerError: An attempt was made to insert an invalid control event variant.';
    END IF;
end;

create or replace definer = root@localhost view control_event_concat_view as
select `courswork`.`control_event`.`id`                   AS `id`,
       `courswork`.`dlsgcv`.`id`                          AS `discipline_lecturer_study_group_id`,
       `courswork`.`dlsgcv`.`group_id`                    AS `group_id`,
       `courswork`.`dlsgcv`.`group_name`                  AS `group_name`,
       `courswork`.`dlsgcv`.`lecturer_id`                 AS `lecturer_id`,
       `courswork`.`dlsgcv`.`lecturer`                    AS `lecturer`,
       `courswork`.`dlsgcv`.`discipline_id`               AS `discipline_id`,
       `courswork`.`dlsgcv`.`discipline`                  AS `discipline`,
       `cet`.`id`                                         AS `control_event_type_id`,
       `cet`.`name`                                       AS `type`,
       `la`.`id`                                          AS `location_auditory_id`,
       concat_ws(' ', `l`.`name`, `la`.`auditory_number`) AS `location`,
       `courswork`.`control_event`.`start_date`           AS `start_date`
from ((((`courswork`.`control_event` join `courswork`.`discipline_lecturer_study_group_concat_view` `dlsgcv`
         on ((`courswork`.`dlsgcv`.`id` =
              `courswork`.`control_event`.`discipline_lecturer_study_group_id`))) join `courswork`.`location_auditory` `la`
        on ((`courswork`.`control_event`.`control_event_auditory_id` = `la`.`id`))) join `courswork`.`location` `l`
       on ((`la`.`location_id` = `l`.`id`))) join `courswork`.`control_event_type` `cet`
      on ((`courswork`.`control_event`.`control_event_type_id` = `cet`.`id`)));

create or replace definer = root@localhost view control_event_id_view as
select `courswork`.`control_event`.`id`                        AS `id`,
       `dlsg`.`study_group_id`                                 AS `study_group_id`,
       `dl`.`discipline_id`                                    AS `discipline_id`,
       `dl`.`lecturer_id`                                      AS `lecturer_id`,
       `la`.`location_id`                                      AS `location_id`,
       `courswork`.`control_event`.`control_event_auditory_id` AS `auditory_id`,
       `courswork`.`control_event`.`control_event_type_id`     AS `type_id`,
       `courswork`.`control_event`.`start_date`                AS `start_date`
from (((`courswork`.`control_event` join `courswork`.`discipline_lecturer_study_group` `dlsg`
        on ((`courswork`.`control_event`.`discipline_lecturer_study_group_id` =
             `dlsg`.`id`))) join `courswork`.`discipline_lecturer` `dl`
       on ((`dlsg`.`discipline_lecturer_id` = `dl`.`id`))) join `courswork`.`location_auditory` `la`
      on ((`courswork`.`control_event`.`control_event_auditory_id` = `la`.`id`)));

create or replace definer = root@localhost view control_event_result_concat_view as
select `courswork`.`control_event_result`.`id`                                                AS `id`,
       `s`.`id`                                                                               AS `student_id`,
       concat_ws(' ', `s`.`surname`, `s`.`name`, `s`.`patronymic`)                            AS `student`,
       `courswork`.`gfv`.`group_id`                                                           AS `group_id`,
       concat_ws(' ', `courswork`.`gfv`.`group_name`, `courswork`.`gfv`.`department_name`,
                 `courswork`.`gfv`.`faculty_name`)                                            AS `student_group`,
       concat_ws(' ', `courswork`.`cev`.`lecturer_surname`, `courswork`.`cev`.`lecturer_name`,
                 `courswork`.`cev`.`lecturer_patronymic`)                                     AS `lecturer`,
       concat_ws(' ', `courswork`.`cev`.`department_name`, `courswork`.`cev`.`faculty_name`)  AS `lecturer_group`,
       concat_ws(' ', `courswork`.`cev`.`location_name`, `courswork`.`cev`.`auditory_number`) AS `location`,
       `courswork`.`cev`.`start_date`                                                         AS `start_date`,
       `courswork`.`cev`.`discipline_name`                                                    AS `discipline_name`,
       `courswork`.`cev`.`control_type`                                                       AS `control_event_type`,
       `c`.`variant_num`                                                                      AS `variant_num`,
       `g`.`name`                                                                             AS `grade`
from (((((`courswork`.`control_event_result` join `courswork`.`student` `s`
          on ((`courswork`.`control_event_result`.`student_id` = `s`.`id`))) join `courswork`.`group_full_view` `gfv`
         on ((`s`.`study_group_id` = `courswork`.`gfv`.`group_id`))) join `courswork`.`grade` `g`
        on ((`courswork`.`control_event_result`.`grade_id` = `g`.`id`))) join `courswork`.`control_event_view` `cev`
       on ((`courswork`.`control_event_result`.`control_event_id` =
            `courswork`.`cev`.`control_event_id`))) join `courswork`.`control_event_variant` `c`
      on ((`courswork`.`control_event_result`.`control_event_variant_id` = `c`.`id`)));

create or replace definer = root@localhost view control_event_variant_id_view as
select `courswork`.`control_event_variant`.`id`          AS `id`,
       `courswork`.`control_event_variant`.`variant_num` AS `variant_num`,
       `dl`.`discipline_id`                              AS `discipline_id`,
       `dl`.`lecturer_id`                                AS `lecturer_id`
from (`courswork`.`control_event_variant` join `courswork`.`discipline_lecturer` `dl`
      on ((`courswork`.`control_event_variant`.`discipline_lecturer_id` = `dl`.`id`)));

create or replace definer = root@localhost view control_event_variant_view as
select `courswork`.`control_event_variant`.`id`          AS `variant_id`,
       `courswork`.`control_event_variant`.`variant_num` AS `variant_num`,
       `dl`.`discipline_id`                              AS `discipline_id`,
       `d`.`name`                                        AS `discipline_name`,
       `dl`.`lecturer_id`                                AS `lecturer_id`,
       `l`.`surname`                                     AS `lecturer_surname`,
       `l`.`name`                                        AS `lecturer_name`,
       `l`.`patronymic`                                  AS `lecturer_patronymic`,
       `d2`.`name`                                       AS `department_name`,
       `f`.`name`                                        AS `faculty_name`
from (((((`courswork`.`control_event_variant` join `courswork`.`discipline_lecturer` `dl`
          on ((`courswork`.`control_event_variant`.`discipline_lecturer_id` =
               `dl`.`id`))) join `courswork`.`lecturer` `l`
         on ((`dl`.`lecturer_id` = `l`.`id`))) join `courswork`.`discipline` `d`
        on ((`dl`.`discipline_id` = `d`.`id`))) join `courswork`.`department` `d2`
       on ((`l`.`department_id` = `d2`.`id`))) join `courswork`.`faculty` `f` on ((`d2`.`faculty_id` = `f`.`id`)));

create or replace definer = root@localhost view control_event_view as
select `courswork`.`control_event`.`id`         AS `control_event_id`,
       `courswork`.`dlgv`.`discipline_id`       AS `discipline_id`,
       `courswork`.`dlgv`.`discipline_name`     AS `discipline_name`,
       `cet`.`name`                             AS `control_type`,
       `courswork`.`dlgv`.`group_id`            AS `group_id`,
       `courswork`.`dlgv`.`group_name`          AS `group_name`,
       `courswork`.`dlgv`.`lecturer_surname`    AS `lecturer_surname`,
       `courswork`.`dlgv`.`lecturer_name`       AS `lecturer_name`,
       `courswork`.`dlgv`.`lecturer_patrinymic` AS `lecturer_patronymic`,
       `courswork`.`control_event`.`start_date` AS `start_date`,
       `l`.`id`                                 AS `location_id`,
       `l`.`name`                               AS `location_name`,
       `la`.`id`                                AS `auditory_id`,
       `la`.`auditory_number`                   AS `auditory_number`,
       `courswork`.`dlgv`.`department_name`     AS `department_name`,
       `courswork`.`dlgv`.`faculty_name`        AS `faculty_name`
from ((((`courswork`.`control_event` join `courswork`.`control_event_type` `cet`
         on ((`courswork`.`control_event`.`control_event_type_id` = `cet`.`id`))) join `courswork`.`discipline_lecturer_group_view` `dlgv`
        on ((`courswork`.`control_event`.`discipline_lecturer_study_group_id` =
             `courswork`.`dlgv`.`id`))) join `courswork`.`location_auditory` `la`
       on ((`courswork`.`control_event`.`control_event_auditory_id` = `la`.`id`))) join `courswork`.`location` `l`
      on ((`la`.`location_id` = `l`.`id`)));

create or replace definer = root@localhost view department_faculty as
select `courswork`.`department`.`id`          AS `department_id`,
       `courswork`.`department`.`name`        AS `department_name`,
       `courswork`.`department`.`description` AS `department_description`,
       `courswork`.`faculty`.`id`             AS `faculty_id`,
       `courswork`.`faculty`.`name`           AS `faculty_name`
from (`courswork`.`department` join `courswork`.`faculty`
      on ((`courswork`.`department`.`faculty_id` = `courswork`.`faculty`.`id`)));

create or replace definer = root@localhost view discipline_lecturer_group_view as
select `courswork`.`discipline_lecturer_study_group`.`id` AS `id`,
       `courswork`.`gsn`.`group_id`                       AS `group_id`,
       `courswork`.`gsn`.`group_name`                     AS `group_name`,
       `l`.`id`                                           AS `lecturer_id`,
       `l`.`surname`                                      AS `lecturer_surname`,
       `l`.`name`                                         AS `lecturer_name`,
       `l`.`patronymic`                                   AS `lecturer_patrinymic`,
       `d`.`id`                                           AS `discipline_id`,
       `d`.`name`                                         AS `discipline_name`,
       `d2`.`name`                                        AS `department_name`,
       `f`.`name`                                         AS `faculty_name`
from ((((((`courswork`.`discipline_lecturer_study_group` join `courswork`.`group_short_name` `gsn`
           on ((`courswork`.`discipline_lecturer_study_group`.`study_group_id` =
                `courswork`.`gsn`.`group_id`))) join `courswork`.`discipline_lecturer` `dl`
          on ((`courswork`.`discipline_lecturer_study_group`.`discipline_lecturer_id` =
               `dl`.`id`))) join `courswork`.`lecturer` `l`
         on ((`dl`.`lecturer_id` = `l`.`id`))) join `courswork`.`discipline` `d`
        on ((`dl`.`discipline_id` = `d`.`id`))) join `courswork`.`department` `d2`
       on ((`l`.`department_id` = `d2`.`id`))) join `courswork`.`faculty` `f` on ((`d2`.`faculty_id` = `f`.`id`)));

create or replace definer = root@localhost view discipline_lecturer_study_group_concat_view as
select `courswork`.`discipline_lecturer_study_group`.`id`                       AS `id`,
       `l`.`id`                                                                 AS `lecturer_id`,
       concat_ws(' ', concat('(', `l`.`id`, ')'), `l`.`surname`, `l`.`name`, `l`.`patronymic`, `d2`.`name`,
                 `f`.`name`)                                                    AS `lecturer`,
       `d`.`id`                                                                 AS `discipline_id`,
       `d`.`name`                                                               AS `discipline`,
       `courswork`.`gsn`.`group_id`                                             AS `group_id`,
       concat_ws(' ', `courswork`.`gsn`.`group_name`, `d3`.`name`, `f2`.`name`) AS `group_name`
from ((((((((((`courswork`.`discipline_lecturer_study_group` join `courswork`.`group_short_name` `gsn`
               on ((`courswork`.`discipline_lecturer_study_group`.`study_group_id` =
                    `courswork`.`gsn`.`group_id`))) join `courswork`.`discipline_lecturer` `dl`
              on ((`courswork`.`discipline_lecturer_study_group`.`discipline_lecturer_id` =
                   `dl`.`id`))) join `courswork`.`lecturer` `l`
             on ((`dl`.`lecturer_id` = `l`.`id`))) join `courswork`.`department` `d2`
            on ((`l`.`department_id` = `d2`.`id`))) join `courswork`.`faculty` `f`
           on ((`d2`.`faculty_id` = `f`.`id`))) join `courswork`.`discipline` `d`
          on ((`dl`.`discipline_id` = `d`.`id`))) join `courswork`.`study_group` `sg`
         on ((`courswork`.`discipline_lecturer_study_group`.`study_group_id` =
              `sg`.`id`))) join `courswork`.`study_group_base` `sgb`
        on ((`sg`.`study_group_base_id` = `sgb`.`id`))) join `courswork`.`department` `d3`
       on ((`sgb`.`department_id` = `d3`.`id`))) join `courswork`.`faculty` `f2` on ((`d3`.`faculty_id` = `f2`.`id`)));

create or replace definer = root@localhost view discipline_lecturer_view as
select `courswork`.`discipline_lecturer`.`id` AS `id`,
       `l`.`id`                               AS `lecturer_id`,
       `l`.`surname`                          AS `lecturer_surname`,
       `l`.`name`                             AS `lecturer_name`,
       `l`.`patronymic`                       AS `lecturer_patronymic`,
       `a`.`name`                             AS `academic_title`,
       `d`.`name`                             AS `discipline_name`,
       `d2`.`name`                            AS `department_name`,
       `f`.`name`                             AS `faculty_name`
from (((((`courswork`.`discipline_lecturer` join `courswork`.`lecturer` `l`
          on ((`courswork`.`discipline_lecturer`.`lecturer_id` = `l`.`id`))) join `courswork`.`academic_title` `a`
         on ((`l`.`academic_title_id` = `a`.`id`))) join `courswork`.`discipline` `d`
        on ((`courswork`.`discipline_lecturer`.`discipline_id` = `d`.`id`))) join `courswork`.`department` `d2`
       on ((`l`.`department_id` = `d2`.`id`))) join `courswork`.`faculty` `f` on ((`d2`.`faculty_id` = `f`.`id`)));

create or replace definer = root@localhost view grade_control_event_type_view as
select `cet`.`name`             AS `control_event_name`,
       `g`.`name`               AS `grade_name`,
       `g`.`id`                 AS `grade_id`,
       `g`.`weight_coefficient` AS `grade_weight_coefficient`,
       `cet`.`id`               AS `control_event_id`
from ((`courswork`.`grade_control_event_type` join `courswork`.`grade` `g`
       on ((`courswork`.`grade_control_event_type`.`grade_id` = `g`.`id`))) join `courswork`.`control_event_type` `cet`
      on ((`courswork`.`grade_control_event_type`.`control_event_type_id` = `cet`.`id`)));

create or replace definer = root@localhost view group_avg_record as
select `courswork`.`group_full_view`.`faculty_id`      AS `faculty_id`,
       `courswork`.`group_full_view`.`faculty_name`    AS `faculty_name`,
       `courswork`.`group_full_view`.`department_id`   AS `department_id`,
       `courswork`.`group_full_view`.`department_name` AS `department_name`,
       `courswork`.`group_full_view`.`group_id`        AS `group_id`,
       `courswork`.`group_full_view`.`group_name`      AS `group_name`,
       avg(`g`.`weight_coefficient`)                   AS `avg_record`
from (((`courswork`.`group_full_view` join `courswork`.`student` on ((`courswork`.`student`.`study_group_id` =
                                                                      `courswork`.`group_full_view`.`group_id`))) join `courswork`.`control_event_result` `cer`
       on ((`courswork`.`student`.`id` = `cer`.`student_id`))) join `courswork`.`grade` `g`
      on ((`cer`.`grade_id` = `g`.`id`)))
group by `courswork`.`group_full_view`.`group_id`;

create or replace definer = root@localhost view group_base_full_view as
select `sgb`.`id`          AS `group_id`,
       `sgb`.`name`        AS `group_name`,
       `sgb`.`description` AS `group_description`,
       `d`.`id`            AS `department_id`,
       `d`.`name`          AS `department_name`,
       `f`.`id`            AS `faculty_id`,
       `f`.`name`          AS `faculty_name`
from ((`courswork`.`study_group_base` `sgb` join `courswork`.`department` `d`
       on ((`d`.`id` = `sgb`.`department_id`))) join `courswork`.`faculty` `f` on ((`f`.`id` = `d`.`faculty_id`)));

create or replace definer = root@localhost view group_full_view as
select `sg`.`id`                                                                                     AS `group_id`,
       concat(`sgb`.`name`, '-', `sg`.`admission_year`, '-', `sg`.`group_num`, `sgp`.`postfix_name`) AS `group_name`,
       `d`.`id`                                                                                      AS `department_id`,
       `d`.`name`                                                                                    AS `department_name`,
       `f`.`id`                                                                                      AS `faculty_id`,
       `f`.`name`                                                                                    AS `faculty_name`
from ((((`courswork`.`study_group` `sg` join `courswork`.`study_group_postfix` `sgp`
         on ((`sg`.`study_group_postfix_id` = `sgp`.`id`))) join `courswork`.`study_group_base` `sgb`
        on ((`sg`.`study_group_base_id` = `sgb`.`id`))) join `courswork`.`department` `d`
       on ((`sgb`.`department_id` = `d`.`id`))) join `courswork`.`faculty` `f` on ((`d`.`faculty_id` = `f`.`id`)));

create or replace definer = root@localhost view group_short_name as
select `sg`.`id`                                                                                     AS `group_id`,
       concat(`sgb`.`name`, '-', `sg`.`admission_year`, '-', `sg`.`group_num`, `sgp`.`postfix_name`) AS `group_name`
from ((`courswork`.`study_group` `sg` join `courswork`.`study_group_postfix` `sgp`
       on ((`sg`.`study_group_postfix_id` = `sgp`.`id`))) join `courswork`.`study_group_base` `sgb`
      on ((`sg`.`study_group_base_id` = `sgb`.`id`)));

create or replace definer = root@localhost view lecturer_full_description as
select `courswork`.`lecturer`.`id`            AS `id`,
       `courswork`.`lecturer`.`name`          AS `name`,
       `courswork`.`lecturer`.`surname`       AS `surname`,
       `courswork`.`lecturer`.`patronymic`    AS `patronimic`,
       `courswork`.`lecturer`.`department_id` AS `department_id`,
       `a`.`name`                             AS `title`,
       `d`.`name`                             AS `department_name`,
       `f`.`name`                             AS `faculty_name`
from (((`courswork`.`lecturer` join `courswork`.`academic_title` `a`
        on ((`courswork`.`lecturer`.`academic_title_id` = `a`.`id`))) join `courswork`.`department` `d`
       on ((`courswork`.`lecturer`.`department_id` = `d`.`id`))) join `courswork`.`faculty` `f`
      on ((`d`.`faculty_id` = `f`.`id`)));

create or replace definer = root@localhost view location_auditory_view as
select `courswork`.`location`.`id`   AS `location_id`,
       `courswork`.`location`.`name` AS `location_name`,
       `la`.`auditory_number`        AS `auditory_number`
from (`courswork`.`location` join `courswork`.`location_auditory` `la`
      on ((`courswork`.`location`.`id` = `la`.`location_id`)));

create or replace definer = root@localhost view student_avg_record as
select `courswork`.`student`.`id`                                  AS `id`,
       `courswork`.`student`.`study_group_id`                      AS `group_id`,
       `courswork`.`group_full_view`.`department_id`               AS `student_department_id`,
       `courswork`.`group_full_view`.`faculty_id`                  AS `student_faculty_id`,
       concat_ws(' ', `courswork`.`group_full_view`.`group_name`, `courswork`.`group_full_view`.`department_name`,
                 `courswork`.`group_full_view`.`faculty_name`)     AS `group`,
       concat_ws(' ', `courswork`.`student`.`surname`, `courswork`.`student`.`name`,
                 `courswork`.`student`.`patronymic`)               AS `student`,
       `dl`.`discipline_id`                                        AS `discipline_id`,
       `d`.`name`                                                  AS `discipline_name`,
       `l`.`id`                                                    AS `lecturer_id`,
       concat_ws(' ', `l`.`surname`, `l`.`name`, `l`.`patronymic`) AS `lecturer`,
       `a`.`name`                                                  AS `title`,
       avg(`g`.`weight_coefficient`)                               AS `avg`
from (((((((((`courswork`.`student` join `courswork`.`control_event_result` on ((`courswork`.`student`.`id` =
                                                                                 `courswork`.`control_event_result`.`student_id`))) join `courswork`.`control_event` `ce`
             on ((`courswork`.`control_event_result`.`control_event_id` = `ce`.`id`))) join `courswork`.`discipline_lecturer_study_group` `dlsg`
            on ((`ce`.`discipline_lecturer_study_group_id` = `dlsg`.`id`))) join `courswork`.`discipline_lecturer` `dl`
           on ((`dlsg`.`discipline_lecturer_id` = `dl`.`id`))) join `courswork`.`discipline` `d`
          on ((`dl`.`discipline_id` = `d`.`id`))) join `courswork`.`lecturer` `l`
         on ((`dl`.`lecturer_id` = `l`.`id`))) join `courswork`.`grade` `g`
        on ((`courswork`.`control_event_result`.`grade_id` = `g`.`id`))) join `courswork`.`academic_title` `a`
       on ((`l`.`academic_title_id` = `a`.`id`))) join `courswork`.`group_full_view`
      on ((`courswork`.`group_full_view`.`group_id` = `courswork`.`student`.`study_group_id`)))
group by `courswork`.`student`.`id`, `d`.`id`, `l`.`id`;

create or replace definer = root@localhost view student_group as
select `courswork`.`student`.`id`                       AS `student_id`,
       `courswork`.`student`.`name`                     AS `name`,
       `courswork`.`student`.`surname`                  AS `surname`,
       `courswork`.`student`.`patronymic`               AS `patronymic`,
       `sg`.`id`                                        AS `group_id`,
       `sgb`.`name`                                     AS `group_name`,
       `sg`.`admission_year`                            AS `admission_year`,
       `sg`.`group_num`                                 AS `group_num`,
       `courswork`.`study_group_postfix`.`postfix_name` AS `postfix`
from (((`courswork`.`student` join `courswork`.`study_group` `sg`
        on ((`courswork`.`student`.`study_group_id` = `sg`.`id`))) join `courswork`.`study_group_postfix`
       on ((`sg`.`study_group_postfix_id` = `courswork`.`study_group_postfix`.`id`))) join `courswork`.`study_group_base` `sgb`
      on ((`sg`.`study_group_base_id` = `sgb`.`id`)));

create or replace definer = root@localhost view student_record as
select `courswork`.`control_event_result`.`student_id` AS `student_id`,
       `courswork`.`group_full_view`.`department_name` AS `department name`,
       `courswork`.`group_full_view`.`faculty_name`    AS `faculty_name`,
       `courswork`.`group_full_view`.`group_name`      AS `group_name`,
       `courswork`.`group_full_view`.`group_id`        AS `group_id`,
       `courswork`.`group_full_view`.`department_id`   AS `department_id`,
       `courswork`.`group_full_view`.`faculty_id`      AS `faculty_id`,
       `courswork`.`student`.`surname`                 AS `surname`,
       `courswork`.`student`.`name`                    AS `name`,
       `courswork`.`student`.`patronymic`              AS `patronymic`,
       sum(`g`.`weight_coefficient`)                   AS `record`
from (((`courswork`.`student` join `courswork`.`control_event_result` on ((`courswork`.`student`.`id` =
                                                                           `courswork`.`control_event_result`.`student_id`))) join `courswork`.`grade` `g`
       on ((`courswork`.`control_event_result`.`grade_id` = `g`.`id`))) join `courswork`.`group_full_view`
      on ((`courswork`.`group_full_view`.`group_id` = `courswork`.`student`.`study_group_id`)))
group by `courswork`.`control_event_result`.`student_id`
order by `record` desc;

create
    definer = root@localhost function control_event_validation(control_event_id int, grade_id int) returns tinyint(1)
    reads sql data
BEGIN
    DECLARE
        control_event_type_id INT UNSIGNED;

    SELECT control_event.control_event_type_id
    INTO control_event_type_id
    FROM control_event
    WHERE control_event.id = control_event_id;
    RETURN grade_validation(control_event_type_id,grade_id);
END;

create
    definer = root@localhost function grade_validation(control_event_type_id int, grade_id int) returns tinyint(1)
    reads sql data
BEGIN
    DECLARE result BOOLEAN;
    SET result = EXISTS(SELECT cet.id   AS control_event_id,
                               cet.name AS control_event_name,
                               g.id     AS grade_id,
                               g.name   as grade_name
                        FROM grade_control_event_type
                                 INNER JOIN control_event_type cet
                                            on grade_control_event_type.control_event_type_id = cet.id
                                 INNER JOIN grade g
                                            on grade_control_event_type.grade_id = g.id
                        WHERE cet.id = control_event_type_id
                          AND g.id = grade_id);
    RETURN result;
END;


