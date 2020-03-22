insert into suspect  ( id , first_name ,last_name ,country , city ,date_in ,date_out ,phonenumber , parent_suspect_id ,descipline , is_infected )
values ( 1 , 'احمد ','حميّر','فرنسا' , 'الشراردة','2020-03-01','2020-03-15','27119665', null,false, false);

insert into suspect  ( id , first_name ,last_name ,country , city ,date_in ,date_out ,phonenumber , parent_suspect_id ,descipline , is_infected )
values ( 2 , 'محمد أمين ','العياري','فرنسا' , 'الشراردة','2020-03-15','2020-03-29','99119665', null,false, false);

insert into suspect  ( id , first_name ,last_name ,country , city ,date_in ,date_out ,phonenumber , parent_suspect_id ,descipline , is_infected )
values ( 3 , 'محمد  ','أمين','إطاليا' , 'العلا','2020-03-15','2020-03-29','97119665', 1,false, false);

-- Used by Spring Remember Me API. h2
CREATE TABLE Persistent_Logins (

                                   username varchar(64) not null,
                                   series varchar(64) not null,
                                   token varchar(64) not null,
                                   last_used Datetime not null,
                                   PRIMARY KEY (series)

);
insert into app_user (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED)
values (2, 'user1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into app_user (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED)
values (1, 'admin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into app_role (ROLE_ID, ROLE_NAME)
values (1, 'ROLE_ADMIN');

insert into app_role (ROLE_ID, ROLE_NAME)
values (2, 'ROLE_USER');



insert into user_role (ID, USER_ID, ROLE_ID)
values (1, 1, 1);

insert into user_role (ID, USER_ID, ROLE_ID)
values (2, 1, 2);

insert into user_role (ID, USER_ID, ROLE_ID)
values (3, 2, 2);
