<h1>myClients myInvoices</h1>
program content:
<ul>
<ol>1. Servlet 3.0.1</ol>
<ol>2. JDBC as database driver</ol>
<ol>3. MySql database</ol>
<ol>4. DBCP2 is also used for data source</ol>
<ol>5. JDBC for mapping retrieved data</ol>
<ol>6. JSON</ol>
<ol>7. Git</ol>
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

11. Import database
SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `tbl_invoices`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_invoices`;
CREATE TABLE `tbl_invoices` (
  `inv_id` int(11) NOT NULL AUTO_INCREMENT,
  `inv_client_id` int(11) NOT NULL,
  `inv_date` datetime NOT NULL,
  `inv_due` datetime DEFAULT NULL,
  `inv_bill_for` varchar(250) DEFAULT NULL,
  `inv_total` double NOT NULL,
  `inv_description` text,
  PRIMARY KEY (`inv_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_invoices
-- ----------------------------
INSERT INTO `tbl_invoices` VALUES ('2', '12', '2017-04-28 23:37:54', '2017-05-05 23:37:57', 'iPhon 7+', '800', 'For purpose to personal use and device tesing');
INSERT INTO `tbl_invoices` VALUES ('5', '12', '2017-03-28 00:00:00', '2017-04-26 00:00:00', 'SmartWatch', '234', 'For my lovely wife');

-- ----------------------------
-- Table structure for `td_customer`
-- ----------------------------
DROP TABLE IF EXISTS `td_customer`;
CREATE TABLE `td_customer` (
  `cus_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cus_firstname` varchar(50) NOT NULL DEFAULT '',
  `cus_lastname` varchar(50) NOT NULL DEFAULT '',
  `cus_gender` varchar(1) DEFAULT NULL COMMENT 'M: Male, F: Female',
  `cus_email_address` varchar(150) DEFAULT NULL,
  `cus_DOB` datetime DEFAULT NULL,
  `cus_address` mediumtext,
  `cus_phoneNumber` varchar(11) DEFAULT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime DEFAULT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of td_customer
-- ----------------------------
INSERT INTO `td_customer` VALUES ('12', 'Jame', 'Ratana', 'M', 'ratana.soth@outlook.com', '2017-03-15 00:00:00', '#88', '12201285', '2017-03-11 10:09:44', '2017-03-11 10:11:00');
INSERT INTO `td_customer` VALUES ('13', 'Chanvoleak', 'Hy', 'M', 'ratana@hbslaw.asia', '2009-03-17 00:00:00', '#1899', '12201285', '2017-03-11 10:10:43', '2017-03-11 11:08:26');
INSERT INTO `td_customer` VALUES ('14', 'Meng', 'Rithy', 'M', 'ratana.soth@gmail.com', '2017-04-29 00:00:00', '', '098 988 98', '2017-04-26 15:35:58', '2017-04-29 02:20:45');

