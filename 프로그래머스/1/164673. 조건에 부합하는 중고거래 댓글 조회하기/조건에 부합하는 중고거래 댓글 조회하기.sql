SELECT 
a.TITLE,
a.BOARD_ID,
b.REPLY_ID,
b.WRITER_ID,
b.CONTENTS,
date_format(b.CREATED_DATE,"%Y-%m-%d") as CREATED_DATE 
from USED_GOODS_BOARD a
Inner 
join USED_GOODS_REPLY  b 
on b.BOARD_ID = a.BOARD_ID
where substr(a.CREATED_DATE,1,7) = "2022-10"


order by b.CREATED_DATE, a.title;