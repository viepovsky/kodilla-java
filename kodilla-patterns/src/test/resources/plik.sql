INSERT INTO POSTS (USER_ID, BODY) VALUES (2,'What do you want to do guys?');
COMMIT;
SELECT * FROM POSTS;
UPDATE POSTS
SET BODY = 'To delete'
WHERE ID = 6;
COMMIT;
DELETE FROM POSTS
WHERE ID = 6;
COMMIT;
SELECT * FROM POSTS;