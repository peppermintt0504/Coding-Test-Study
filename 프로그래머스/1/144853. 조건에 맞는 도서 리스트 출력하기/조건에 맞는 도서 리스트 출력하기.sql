SELECT BOOK_ID , date_format(Published_date,"%Y-%m-%d") PUBLISHED_DATE from Book
where year(Published_date) = 2021 AND CATEGORY = "인문"
order by Published_date;