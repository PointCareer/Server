-- src/main/resources/data.sql

SET FOREIGN_KEY_CHECKS=0;
TRUNCATE TABLE recruit_bookmark;
TRUNCATE TABLE recruit_category;
TRUNCATE TABLE recruit;
TRUNCATE TABLE category;
TRUNCATE TABLE user;
SET FOREIGN_KEY_CHECKS=1;
-- 1) 카테고리
INSERT INTO category (category_id, type, name) VALUES
(1, 'FAVORITE', 'IT_DEVELOP'),
(2, 'ACTIVITY_CATEGORY', 'JOB_PREPARATION'),
(3, 'RECRUIT_JOB', 'DEVELOPMENT_TECH');

-- 2) 채용 공고
INSERT INTO recruit (
    recruit_id, title, company, type, place, deadline, detail, link_url, image_url, created_at, updated_at
) VALUES
      (1, '백엔드 개발자 채용', '포인트커리어', 'FULL_TIME', '서울', '2025-07-01 23:59:59', '우리 팀에서…', 'https://apply.example.com/1', 'https://img.example.com/1.png', NOW(), NOW()),
      (2, '프론트엔드 개발자 채용', '포인트커리어', 'CONTRACT', '부산', '2025-08-01 23:59:59', '멋진 UI를…', 'https://apply.example.com/2', 'https://img.example.com/2.png', NOW(), NOW());
-- 3) RecruitCategory (N:M 매핑)
INSERT INTO recruit_category (recruit_category_id, recruit_id, category_id) VALUES
(1, 1, 1),
(2, 1, 3),  -- 공고 1에 RECRUIT_JOB:BACKEND
(3, 2, 2);  -- 공고 2에 RECRUIT_JOB:BACKEND



-- 4) 유저
INSERT INTO user (
    user_id, login_id, email, name, password, grade, major, semester,
    user_point, remain_point, created_at, updated_at
) VALUES (
             1,
             'honggildong',
             'hong@example.com',
             '홍길동',
             '$2a$10$EixZaYVK1fsbw1ZfbX3OXePaWxn96p36h3dNhCeuFq2zXI5Q5f0yW',
             3,
             '컴공',
             '1학기',
             0,
             0,
             NOW(),
             NOW()
         ),
        (2,
         'nam123',
         'rkvpd1@naver.com',
         '남',
         '$2a$10$oUND3wWLP54rSeHUiN3ghuG0RvCNaDizau7mNwLOf4IJtug092.f6',
         3,
         '컴공',
         '1학기',
         0,
         0,
         NOW(),
         NOW());

-- 5) RecruitBookmark
INSERT INTO recruit_bookmark (recruit_bookmark_id, user_id, recruit_id, created_at, updated_at)
VALUES
    (1, 1, 1, NOW(), NOW());