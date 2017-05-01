<h1>myClients myInvoices</h1>
program content:
<ul>
<ol>1. Servlet 3.0.1</ol>
<ol>2. JDBC as database driver</ol>
<ol>3. MySql database</ol>
<ol>4. DBCP2 is also used for data source</ol>
<ol>5. JDBC for mapping retrieved data</ol>
<ol>6. JSON</ol>
</ul>
<h2>Program Feature</h2>
<ul>
	<li>User Login </li>
	<li>Customer List with phone/address filter and pagination</li>
	<li>Create, read, update, delete customer</li>
	<li> Invoice management</li>
	<li>Create, read, update, delete invoice</li>
</ul>

<h2>Installation for Development Environment</h2>


1. Clone project from this repository:
<pre>
git clone git@github.com:ratanasoth/myClients_myInvoices.git
</pre>

2. Import database from customer-management.sql in the root of project
3. Update database connection configuration in src/main/resources/application.properties as your user access to database.
4. cd to project directory
5. Install maven dependencies:
<pre>
mvn install
</pre>

6. Generate Eclipse IDE files (Specifically for Eclipse):
<pre>
mvn eclipse:eclipse
</pre>

7. Import project to IDE
8. Start web server service using jetty
<pre>
mvn jetty:run
</pre>
9. Open browser by URL:
<pre>
http:localhost:8080
</pre>

10. Login account:
<pre>
username: admin, password: adminPassword
username: user-test, password: userPassword
</pre>

