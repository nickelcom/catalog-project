--FAIL_CODE Inserts
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (-1,'NoFailCode','Success',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (1,'fail','Fail Code - fail',sysdate,sysdate,'Y');

-- new workflow related fail codes (currently leaving an id gap in case of overlap as dev vs QA differs)
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (100,'FAILTOPARSE','Failed to parse document',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (101,'ISCREDIT','Credit note detected when not allowed',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (102,'DUPLICATE','Duplicate invoice detected',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (103,'DATEOLDERTHANXDAYS','Invoice date older than allowed days',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (104,'DATEINFUTURE','Invoice date more then allowed days in the future',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (105,'INVOICEHASZEROTOTAL','Invoice total is zero',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (106,'ZEROLINEITEMS','Invoice has no line items',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (107,'INVOICEHASPOSITIVEANDNEGATIVELINES','Invoice has both positive and negative lines',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (108,'CALCULATIONPROBLEM','Invoice calculation problem detected',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (109,'INVOICEHASNEGATIVELINES','Invoice has negative amounts in lines',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (110,'NOPOPREFIX','PO number does not start with required prefix',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (111,'NOPONUMBER','PO number could not be extracted from invoice',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (112,'NOLINES','Invoice contains no invoice lines',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (113,'DATATOOBIG','Invoice contains data larger than specified',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (114,'INVALIDDATE','Invoice has an invalid invoice date',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (115,'NOINVOICENO','Invoice number could not be extracted from invoice',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (117,'STARTSWITH','Invoice number does not start with required prefix',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (118,'INVOICENOTOOBIG','Invoice number size exceeds permitted size',sysdate,sysdate,'N');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (119,'FAILTOOPEN','Invoice could not be opened',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (120,'ZEROVALUELINE','Invoice has a zero value line item',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (121,'POFORMAT','Invoice PO Number not in desired format',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (122,'INVOICEREJECTED','Invoice was rejected',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (123,'SUMMARYINVOICE','Summary invoice detected',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (124,'LINECALCULATIONPROBLEM','Unit price not equal to net times quantity',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (125,'TOTALSDONTADD','The net amount does not equal the sum of the lines',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (126,'TRIAGEFAILED','Triage Processing Failed',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG) VALUES (127,'TRIAGEFAILEDNODOC','Triage Processing Failed - Invoice Document Not Found',sysdate,sysdate,'Y');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG,TEXT) VALUES (128,'MAXRETRIES','Max number of delivery retries has been reached',sysdate,sysdate,'Y','Maximum Number of Retries Exceeded');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG,TEXT) VALUES (129,'PDFISIMAGE','Pdf detected as an image',sysdate,sysdate,'Y','Pdf detected as an image');
INSERT INTO FAIL_CODE (ID,NAME,DESCRIPTION,DATE_ROW_ADDED,DATE_ROW_UPDATED,ACTIVE_FLAG,TEXT) VALUES (130,'MANUALTRIAGE','Manual triage',sysdate,sysdate,'Y','Manual triage');

--USERS
INSERT INTO USERS(ID, USER_NAME, PASSWORD, FIRST_NAME, LAST_NAME, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES(1, 'sysadmin', 'sysadmin','System', 'Administrator', sysdate, sysdate, 'Y');
INSERT INTO USERS(ID, USER_NAME, PASSWORD, FIRST_NAME, LAST_NAME, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES(2, 'zmodica', 'zmodica','Zack', 'Modica', sysdate, sysdate, 'Y');
INSERT INTO USERS(ID, USER_NAME, PASSWORD, FIRST_NAME, LAST_NAME, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES(3, 'rdatar', 'rdatar','Raj', 'Datar', sysdate, sysdate, 'Y');
ALTER SEQUENCE USERS_SEQ RESTART START WITH 4;

--ROLES
INSERT INTO AUTH(AUTH_NAME, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES('All', sysdate, sysdate, 'Y');
INSERT INTO AUTH(AUTH_NAME, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES('ADMIN', sysdate, sysdate, 'Y');
INSERT INTO AUTH(AUTH_NAME, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES('REPORTS', sysdate, sysdate, 'Y');	
INSERT INTO AUTH(AUTH_NAME, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES('PROFILES', sysdate, sysdate, 'Y');	
INSERT INTO AUTH(AUTH_NAME, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES('TRANSACTIONS', sysdate, sysdate, 'Y');
INSERT INTO AUTH(AUTH_NAME, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES('NORMALIZEDSUPPLIERNAME', sysdate, sysdate, 'Y');
INSERT INTO AUTH(AUTH_NAME, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES('MANUALENTRY', sysdate, sysdate, 'Y');	

--USER_AUTH
INSERT INTO USER_AUTH(USER_ID, AUTH_NAME, CAN_READ, CAN_WRITE, CAN_DELETE, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES(1,'REPORTS', 'Y','Y', 'Y', sysdate, sysdate, 'Y');
INSERT INTO USER_AUTH(USER_ID, AUTH_NAME, CAN_READ, CAN_WRITE, CAN_DELETE, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES(1,'TRANSACTIONS', 'Y','Y', 'Y', sysdate, sysdate, 'Y');
INSERT INTO USER_AUTH(USER_ID, AUTH_NAME, CAN_READ, CAN_WRITE, CAN_DELETE, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES(1,'PROFILES', 'Y','Y', 'Y', sysdate, sysdate, 'Y');
INSERT INTO USER_AUTH(USER_ID, AUTH_NAME, CAN_READ, CAN_WRITE, CAN_DELETE, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES(2,'REPORTS', 'Y','Y', 'Y', sysdate, sysdate, 'Y');
INSERT INTO USER_AUTH(USER_ID, AUTH_NAME, CAN_READ, CAN_WRITE, CAN_DELETE, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES(2,'TRANSACTIONS', 'Y','Y', 'Y', sysdate, sysdate, 'Y');
INSERT INTO USER_AUTH(USER_ID, AUTH_NAME, CAN_READ, CAN_WRITE, CAN_DELETE, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES(2,'PROFILES', 'Y','Y', 'Y', sysdate, sysdate, 'Y');
INSERT INTO USER_AUTH(USER_ID, AUTH_NAME, CAN_READ, CAN_WRITE, CAN_DELETE, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES(2,'ADMIN', 'Y','Y', 'Y', sysdate, sysdate, 'Y');
INSERT INTO USER_AUTH(USER_ID, AUTH_NAME, CAN_READ, CAN_WRITE, CAN_DELETE, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES(3,'REPORTS', 'Y','Y', 'Y', sysdate, sysdate, 'Y');
INSERT INTO USER_AUTH(USER_ID, AUTH_NAME, CAN_READ, CAN_WRITE, CAN_DELETE, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES(3,'TRANSACTIONS', 'Y','Y', 'Y', sysdate, sysdate, 'Y');
INSERT INTO USER_AUTH(USER_ID, AUTH_NAME, CAN_READ, CAN_WRITE, CAN_DELETE, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES(3,'PROFILES', 'Y','Y', 'Y', sysdate, sysdate, 'Y');
INSERT INTO USER_AUTH(USER_ID, AUTH_NAME, CAN_READ, CAN_WRITE, CAN_DELETE, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES(3,'ADMIN', 'Y','Y', 'Y', sysdate, sysdate, 'Y');
INSERT INTO USER_AUTH(USER_ID, AUTH_NAME, CAN_READ, CAN_WRITE, CAN_DELETE, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES(3,'MANUALENTRY', 'Y','Y', 'Y', sysdate, sysdate, 'Y');

-- ACTION LOOKUPS
INSERT INTO ACTION(ID, ACTION, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES(1,'Forward to Custom Email',sysdate,sysdate,'Y');
INSERT INTO ACTION(ID, ACTION, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES(2,'Forward to Supplier',sysdate,sysdate,'Y');
INSERT INTO ACTION(ID, ACTION, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES(3,'Forward to Buyer',sysdate,sysdate,'Y');
INSERT INTO ACTION(ID, ACTION, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES(4,'Retry',sysdate,sysdate,'Y');
INSERT INTO ACTION(ID, ACTION, DATE_ROW_ADDED, DATE_ROW_UPDATED, ACTIVE_FLAG) VALUES(5,'Retry / No Workflow',sysdate,sysdate,'Y');
ALTER SEQUENCE TRIAGE_ACTION_SEQ RESTART START WITH 6;

UPDATE FAIL_CODE SET TEXT='No Fail Code' WHERE ID=-1;
UPDATE FAIL_CODE SET TEXT='FailCode 1' WHERE ID=1;
UPDATE FAIL_CODE SET TEXT='FailCode 2' WHERE ID=2;
UPDATE FAIL_CODE SET TEXT='Fail' WHERE ID=41;
UPDATE FAIL_CODE SET TEXT='Fail' WHERE ID=61;
UPDATE FAIL_CODE SET TEXT='Failed To Parse' WHERE ID=100;
UPDATE FAIL_CODE SET TEXT='Is Credit' WHERE ID=101;
UPDATE FAIL_CODE SET TEXT='Duplicate' WHERE ID=102;
UPDATE FAIL_CODE SET TEXT='Date Older Than x Days' WHERE ID=103;
UPDATE FAIL_CODE SET TEXT='Date In Future' WHERE ID=104;
UPDATE FAIL_CODE SET TEXT='Invoice Has Zero Total' WHERE ID=105;
UPDATE FAIL_CODE SET TEXT='Zero Line Items' WHERE ID=106;
UPDATE FAIL_CODE SET TEXT='Invoice Has Positive And Negative Lines' WHERE ID=107;
UPDATE FAIL_CODE SET TEXT='Calculation Problem' WHERE ID=108;
UPDATE FAIL_CODE SET TEXT='Invoice Has Negative Lines' WHERE ID=109;
UPDATE FAIL_CODE SET TEXT='No PO Prefix' WHERE ID=110;
UPDATE FAIL_CODE SET TEXT='No PO Number' WHERE ID=111;
UPDATE FAIL_CODE SET TEXT='No Lines' WHERE ID=112;
UPDATE FAIL_CODE SET TEXT='Data Too Big' WHERE ID=113;
UPDATE FAIL_CODE SET TEXT='Invalid Date' WHERE ID=114;
UPDATE FAIL_CODE SET TEXT='No Invoice Number' WHERE ID=115;
UPDATE FAIL_CODE SET TEXT='Multiple Work Flow Failures' WHERE ID=116;
UPDATE FAIL_CODE SET TEXT='Starts With' WHERE ID=117;
UPDATE FAIL_CODE SET TEXT='Invoice Number Exceeds Character Limit' WHERE ID=118;
UPDATE FAIL_CODE SET TEXT='Failed To Open' WHERE ID=119;
UPDATE FAIL_CODE SET TEXT='Zero Value Line' WHERE ID=120;
UPDATE FAIL_CODE SET TEXT='PO Format' WHERE ID=121;
UPDATE FAIL_CODE SET TEXT='Summary Invoice' WHERE ID=123;
UPDATE FAIL_CODE SET TEXT='Line Calculation Problem' WHERE ID=124;
UPDATE FAIL_CODE SET TEXT='Totals Dont Add' WHERE ID=125;
UPDATE FAIL_CODE SET TEXT='Triage Failed' WHERE ID=126;
UPDATE FAIL_CODE SET TEXT='Triage Failed - No Document Found' WHERE ID=127;

INSERT INTO TAX_TYPES(ID, KEY, DESCRIPTION, PERCENTAGE, ACTIVE_FLAG, DATE_ROW_ADDED, DATE_ROW_UPDATED) VALUES(1, 'S', 'Standard UK VAT', 20.0, 'Y', SYSDATE, SYSDATE);
INSERT INTO TAX_TYPES(ID, KEY, DESCRIPTION, PERCENTAGE, ACTIVE_FLAG, DATE_ROW_ADDED, DATE_ROW_UPDATED) VALUES(2, 'Z', 'Zero Exempt VAT', 0.0, 'Y', SYSDATE, SYSDATE);
INSERT INTO TAX_TYPES(ID, KEY, DESCRIPTION, PERCENTAGE, ACTIVE_FLAG, DATE_ROW_ADDED, DATE_ROW_UPDATED) VALUES(3, 'R', 'Reduced UK VAT', 5.0, 'Y', SYSDATE, SYSDATE);
ALTER SEQUENCE TAX_TYPES_SEQ RESTART START WITH 4;


/