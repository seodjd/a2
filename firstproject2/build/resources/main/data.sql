INSERT INTO article(id, title, content) VALUES(1, '가가가가', '1111');
INSERT INTO article(id, title, content) VALUES(2, '가가가가', '1111');
INSERT INTO article(id, title, content) VALUES(3, '가가가가', '1111');

-- article 더미 데이터 --

INSERT INTO article(id, title, content) VALUES(4, '당신의 인생 영화는?', '댓글1');
INSERT INTO article(id, title, content) VALUES(5, '당신의 소울푸드는?', '댓글2');
INSERT INTO article(id, title, content) VALUES(6, '당신의 취미는?', '댓글3');

-- comment 더미 데이터 --

INSERT INTO comment(id, article_id, nickname, body) VALUES (1, 4, 'Part', '굳 윌 헌팅');
INSERT INTO comment(id, article_id, nickname, body) VALUES (2, 4, 'Kim', '아이 엠 샘');
INSERT INTO comment(id, article_id, nickname, body) VALUES (3, 4, 'Choi', '쇼생크의 탈출');

-- 5번 게시글의 댓글

INSERT INTO comment(id, article_id, nickname, body) VALUES (4, 5, 'Part', '굳 윌 헌팅');
INSERT INTO comment(id, article_id, nickname, body) VALUES (5, 5, 'Kim', '아이 엠 샘');
INSERT INTO comment(id, article_id, nickname, body) VALUES (6, 5, 'Choi', '쇼생크의 탈출');

-- 6번 게시글 댓글 --

INSERT INTO comment(id, article_id, nickname, body) VALUES (7, 6, 'Part', '굳 윌 헌팅');
INSERT INTO comment(id, article_id, nickname, body) VALUES (8, 6, 'Kim', '아이 엠 샘');
INSERT INTO comment(id, article_id, nickname, body) VALUES (9, 6, 'Choi', '쇼생크의 탈출');



