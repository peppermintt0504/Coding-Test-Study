SELECT 
DR_NAME,DR_ID,MCDP_CD,date_format(HIRE_YMD,"%Y-%m-%d") HIRE_YMD
from DOCTOR
where MCDP_CD ="CS" OR MCDP_CD = "Gs"
order by HIRE_YMD DESC, DR_NAME
;