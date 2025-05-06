-- 🌟 EVENT_TBL 등록
INSERT INTO EVENT_TBL (
    EVENT_NAME, EVENT_SHORT_INFO, EVENT_BACKGROUND, EVENT_PROGRESS, EVENT_MEANING,
    EVENT_DATE, EVENT_NATION, EVENT_CATEGORY,
    EVENT_NAME_ENG, EVENT_NATION_ENG, EVENT_CATEGORY_ENG,
    EVENT_IMAGE, EVENT_STAMP_IMAGE
) VALUES
      (
          '5.18 광주민주화운동',
          '1980년 5월 광주에서 벌어진 민주화 운동',
          '박정희 정권 이후 전두환 정권의 출범 과정 속에서 발생한 시민 저항',
          '계엄령 확대, 시민들의 시위, 군의 진압, 그리고 최종적인 항쟁 종료',
          '대한민국 민주주의 발전에 결정적인 역할을 한 역사적 사건',
          '1980-05-18 00:00:00',
          '대한민국', '민주화운동',
          'Gwangju Uprising', 'Republic of Korea', 'Democratization Movement',
          'https://example.com/images/gwangju.jpg', 'https://example.com/images/stamp1.jpg'
      ),
      (
          '광주학생항일운동',
          '1929년 광주에서 벌어진 항일 독립 운동',
          '일제 강점기 조선인 학생들에 대한 차별에 저항한 사건',
          '광주에서 시작된 시위가 전국적으로 확산됨',
          '학생들이 중심이 되어 일제에 항거한 대표적인 독립운동',
          '1929-11-03 00:00:00',
          '대한민국', '독립운동',
          'Gwangju Student Independence Movement', 'Republic of Korea', 'Independence Movement',
          'https://example.com/images/independence.jpg', 'https://example.com/images/stamp2.jpg'
      );

-- 📍 LOCATION_TBL 등록
INSERT INTO LOCATION_TBL (
    LOC_NAME, LOC_EVENT, LOC_ADDREESS, LOC_IMAGE,
    LOC_SHORT_INFO, LOC_HISTORIC_INFO, LOC_ETIQUETTE,
    LOC_OPEN_TIME, LOC_CLOSE_TIME, LOC_PHONE_NUM,
    EXHIBITION_TIME, AVAILABLE, TRANSLATE,
    LOC_NAME_ENG, LOC_ADDRESS_ENG
) VALUES
      (
          '금남로', 1, '광주광역시 동구 금남로', 'https://example.com/images/geumnamro.jpg',
          '5.18 민주화운동 당시 주요 시위 장소',
          '역사적으로 중요한 시위의 중심지였던 거리입니다.',
          '방문 시 정숙을 유지해주세요.',
          '2023-01-01 09:00:00', '2023-01-01 18:00:00',
          '062-123-4567', '09:00 ~ 18:00', 'Y', 'Y',
          'Geumnam-ro', 'Geumnam-ro, Dong-gu, Gwangju, South Korea'
      ),
      (
          '광주학생독립운동기념관', 2, '광주광역시 서구 학생독립로 30', 'https://example.com/images/independence.jpg',
          '광주학생항일운동을 기념하는 전시관',
          '일제에 항거한 학생들의 용기를 기리는 공간입니다.',
          '조용히 관람해 주세요.',
          '2023-01-01 10:00:00', '2023-01-01 17:00:00',
          '062-987-6543', '10:00 ~ 17:00', 'Y', 'Y',
          'Gwangju Student independence Movement Memorial Hall',
          '30, Hwajeong-dong, Seo-gu, Gwangju-si, South Korea'
      );

-- 🏷️ KEYWORD_TBL 등록
INSERT INTO KEYWORD_TBL (
    KEYWORD, KEYWORD_EVENT, KEYWORD_LOCATION, KEYWORD_KOR_ENG
) VALUES
      ('민주주의', 1, 1, 0),
      ('Gwangju', 1, 1, 1),
      ('시민 저항', 1, 1, 0);

-- 👤 USER_TBL 등록
INSERT INTO USER_TBL (
    USER_EMAIL, USER_UID
) VALUES
      ('user@example.com', 'firebase-uid-001'),
      ('user2@example.com', 'firebase-uid-002'),
         ('user3@example.com', 'firebase-uid-003'),
         ('user4@example.com', 'firebase-uid-004'),
         ('user5@example.com', 'firebase-uid-005');

-- 💌 LETTER_TBL 등록
INSERT INTO LETTER_TBL (
    LETTER_LOCATION, LETTER_USER, LETTER_STAMP_IMG, LETTER_MARK_IMG,
    LETTER_CONTENT, LETTER_TIME
) VALUES (
             1, 1, 'https://example.com/stamp.jpg', 'https://example.com/mark.jpg',
             'AI가 작성한 편지입니다.', CURRENT_TIMESTAMP
         );

-- 🧭 STAMP_TBL 등록
INSERT INTO STAMP_TBL (
    STAMP_LOCATION, STAMP_OWNER, STAMP_EVENT, STAMP_STATUS, STAMP_IMAGE
) VALUES
      (1, 1, 1, CURRENT_TIMESTAMP, 'image.jpg'),
      (2, 1, 2, CURRENT_TIMESTAMP, 'image.jpg');

-- 📌 VISITED_TBL 등록 (최신 구조 반영)
INSERT INTO VISITED_TBL (
    VISITED_USER, VISITED_LOCATION, VISITED_COMMENT, VISITED_LIKES,
    VISITED_CREATED_AT, VISITED_UPDATED_AT,
    VISITED_IS_EDITED, VISITED_IS_DELETED, VISITED_IMAGE
) VALUES (
             1, 1, '광주의 진실을 기억합니다.', 5,
             CURRENT_TIMESTAMP, NULL, false, false,
             'https://example.com/images/comment1.jpg'
         );