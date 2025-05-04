-- 🌟 Event 등록
INSERT INTO EVENT_TBL (
    EVENT_NAME, EVENT_INFO, EVENT_DATE, EVENT_NATION, EVENT_CATEGORY,
    EVENT_NAME_ENG, EVENT_NATION_ENG, EVENT_CATEGORY_ENG
) VALUES (
             '5.18 광주민주화운동', '1980년 5월 광주에서 벌어진 민주화 운동',
             '1980-05-18 00:00:00', '대한민국', '민주화운동',
             'Gwangju Uprising', 'Republic of Korea', 'Democratization Movement'
         );

INSERT INTO EVENT_TBL (
    EVENT_NAME, EVENT_INFO, EVENT_DATE, EVENT_NATION, EVENT_CATEGORY,
    EVENT_NAME_ENG, EVENT_NATION_ENG, EVENT_CATEGORY_ENG
) VALUES (
             '광주학생항일운동', '1929년 광주에서 벌어진 항일 독립 운동',
             '1980-11-03 00:00:00', '대한민국', '독립운동',
             'Gwangju Student Independence Movement', 'Republic of Korea', 'Independence Movement'
         );

-- 📍 Location 등록
INSERT INTO LOCATION_TBL (
    LOC_NAME, LOC_EVENT, LOC_ADDREESS, LOC_IMAGE,
    LOC_INFO, LOC_NAME_ENG, LOC_INFO_ENG, LOC_ADDRESS_ENG
) VALUES (
             '금남로', 1, '광주광역시 동구 금남로', 'https://example.com/images/geumnamro.jpg',
             '5.18 민주화운동 당시 주요 시위 장소',
             'Geumnam-ro', 'Main protest site during the May 18 Gwangju Uprising',
             'Geumnam-ro, Dong-gu, Gwangju, South Korea'
         );

INSERT INTO LOCATION_TBL (
    LOC_NAME, LOC_EVENT, LOC_ADDREESS, LOC_IMAGE,
    LOC_INFO, LOC_NAME_ENG, LOC_INFO_ENG, LOC_ADDRESS_ENG
) VALUES (
             '광주학생독립운동기념관', 2, '광주광역시 서구 학생독립로 30', 'https://example.com/images/independence.jpg',
             '광주학생항일운동을 기념하는 전시관',
             'Gwangju Student independence Movement Memorial Hall', 'Exhibition Hall commemorating Gwangju Student Anti-Japanese Movement',
             '30, Hwajeong-dong, Seo-gu, Gwangju-si, South Korea'
         );

-- 🏷️ Keyword 등록
INSERT INTO KEYWORD_TBL (
    KEYWORD, KEYWORD_EVENT, KEYWORD_LOCATION, KEYWORD_KOR_ENG
) VALUES
      ('민주주의', 1, 1, 0),
      ('Gwangju', 1, 1, 1),
      ('시민 저항', 1, 1, 0);

-- 👤 User 등록
INSERT INTO USER_TBL (
    USER_EMAIL, USER_UID
) VALUES (
             'user@example.com', 'firebase-uid-001'
         );

-- 💌 Letter 등록
INSERT INTO LETTER_TBL (
    LETTER_LOCATION, LETTER_USER, LETTER_STAMP_IMG, LETTER_MARK_IMG,
    LETTER_CONTENT, LETTER_TIME
) VALUES (
             1, 1, 'https://example.com/stamp.jpg', 'https://example.com/mark.jpg',
             'AI가 작성한 편지입니다.', CURRENT_TIMESTAMP
         );

-- 🧭 Stamp 등록
INSERT INTO STAMP_TBL (
    STAMP_LOCATION, STAMP_OWNER, STAMP_EVENT, STAMP_STATUS, STAMP_IMAGE
) VALUES (
             1, 1, 1, CURRENT_TIMESTAMP, 'image.jpg'
         );

INSERT INTO STAMP_TBL (
    STAMP_LOCATION, STAMP_OWNER, STAMP_EVENT, STAMP_STATUS, STAMP_IMAGE
) VALUES (
             2, 1, 2, CURRENT_TIMESTAMP, 'image.jpg'
         );

-- 📌 Visited 등록
INSERT INTO VISITED_TBL (
    VISITED_USER, VISITED_LOCATION, VISITED_DATE, VISITED_COMMENT, VISITED_LIKES
) VALUES (
             1, 1, CURRENT_TIMESTAMP, '광주의 진실을 기억합니다.', 5
         );
