SELECT MEMBER_ID, MEMBER_NAME, GENDER, date_format(DATE_OF_BIRTH,"%Y-%m-%d") DATE_OF_BIRTH from member_profile
where GENDER Like "W"
And TLNO is Not Null
And Month(date_of_birth) = 3
order by member_id
;