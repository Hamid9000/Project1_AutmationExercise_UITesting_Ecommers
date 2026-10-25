https://www.automationexercise.com/



//Db crfedetaion
db.url=jdbc:mysql://localhost:3306/APITesting_AutomationExercise
db.username=automation_user
db.password=Automation@123
db.table=Product_Search_TestData

Id vimuzebyku@mailinator.com
pass Pa$$w0rd!
name Elijah Mcintyre

#command for allure report
*To open report ->
allure serve target/allure-results

*To genrate report folder
allure generate target/allure-results --clean -o target/allure-report

*To open zip file CMD me run krn hai
allure open "C:\Users\hamid\Downloads\allure-report\allure-report"

for delet old file
Remove-Item -Recurse -Force .\target\allure-results -ErrorAction SilentlyContinue

sirf smoke suite run karne ke lia
mvn clean test "-Dsurefire.suiteXmlFiles=src/test/resources/test-suites/testng-smoke.xml"

Project Address
C:\Users\hamid\IdeaProjects\Project1_AutmationExercise_UITesting_Ecommers 