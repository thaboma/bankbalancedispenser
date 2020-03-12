# ATM withdrwal system
use http://localhost:8080/swagger-ui.html#/ to run the simple service as soon as you run the application
http://localhost:8080/h2-console to run in memory database



   4.2.4	Reporting – Find the transactional account per client with the highest balance

 WITH MaxBal AS (
SELECT ROW_NUMBER() OVER(PARTITION BY CLIENT_ID ORDER BY DISPLAY_BALANCE  DESC) AS rank,*
		FROM  (	
		        SELECT c.CLIENT_ID,c.SURNAME, 
					   ca.CLIENT_ACCOUNT_NUMBER,
					   at.DESCRIPTION,
					   ca.DISPLAY_BALANCE 
				FROM CLIENT c
				INNER JOIN CLIENT_ACCOUNT ca ON c.CLIENT_ID=ca.CLIENT_ID
				INNER JOIN  ACCOUNT_TYPE at ON  ca.ACCOUNT_TYPE_CODE=at.ACCOUNT_TYPE_CODE
				GROUP BY c.CLIENT_ID,c.SURNAME, ca.CLIENT_ACCOUNT_NUMBER ,at.DESCRIPTION
                       )  
)
SELECT  CLIENT_ID,SURNAME,CLIENT_ACCOUNT_NUMBER, DESCRIPTION,DISPLAY_BALANCE 
FROM MaxBal
WHERE rank=1


	4.2.5	Reporting – Calculate aggregate financial position per client

* Client (Client Title + Client Name + Client Surname)

 WITH Bal AS (
   SELECT C.CLIENT_ID,TITLE,NAME,SURNAME,SUM(DISPLAY_BALANCE) AS TOTAL_BAL
			FROM CLIENT  C
			INNER JOIN CLIENT_ACCOUNT ca ON c.CLIENT_ID=ca.CLIENT_ID
 GROUP BY  C.CLIENT_ID,TITLE,NAME,SURNAME
)  

* Transactional balance
 WITH TransBal AS (
SELECT ca.CLIENT_ID,SUM(ca.DISPLAY_BALANCE)

			FROM CLIENT c
			INNER JOIN CLIENT_ACCOUNT ca ON c.CLIENT_ID=ca.CLIENT_ID
			INNER JOIN  ACCOUNT_TYPE at ON  ca.ACCOUNT_TYPE_CODE=at.ACCOUNT_TYPE_CODE
                        INNER JOIN CURRENCY  cur ON cur.CURRENCY_CODE =ca.CURRENCY_CODE
			WHERE at.TRANSACTIONAL =1
GROUP BY ca.CLIENT_ID
) SELECT * FROM TransBal 

* Net Position 

 WITH NetPos AS (
SELECT ca.CLIENT_ID,SUM(ca.DISPLAY_BALANCE)

			FROM CLIENT c
			INNER JOIN CLIENT_ACCOUNT ca ON c.CLIENT_ID=ca.CLIENT_ID
			INNER JOIN  ACCOUNT_TYPE at ON  ca.ACCOUNT_TYPE_CODE=at.ACCOUNT_TYPE_CODE
                        INNER JOIN CURRENCY  cur ON cur.CURRENCY_CODE =ca.CURRENCY_CODE
GROUP BY ca.CLIENT_ID
) SELECT * FROM NetPos 

TO DO

Am left with joining the 3 tables ....

