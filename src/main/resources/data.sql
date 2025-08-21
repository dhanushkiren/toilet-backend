-- =============================
-- ROLES
-- =============================
INSERT INTO roles (id, name) VALUES
(1, 'SUPERVISOR'),
(2, 'CLEANER'),
(3, 'INSPECTOR'),
(4, 'MANAGER'),
(5, 'HEADMASTER');

-- =============================
-- USERS
-- password = "password" (BCrypt hash, you can generate with Spring Security PasswordEncoder)
-- hash for "password" -> $2a$10$Dow1.2fW0bg2zVb91mW6Oe8Y8rsdR5TruWy3vZW1fRzYIYQzX5nl6
-- =============================
INSERT INTO users (id, username, password, role_id, full_name, phone, email) VALUES
(1, 'supervisor1', '$2a$10$Dow1.2fW0bg2zVb91mW6Oe8Y8rsdR5TruWy3vZW1fRzYIYQzX5nl6', 1, 'Supervisor One', '9876543210', 'supervisor1@example.com'),
(2, 'cleaner1', '$2a$10$Dow1.2fW0bg2zVb91mW6Oe8Y8rsdR5TruWy3vZW1fRzYIYQzX5nl6', 2, 'Cleaner One', '9876500001', 'cleaner1@example.com'),
(3, 'cleaner2', '$2a$10$Dow1.2fW0bg2zVb91mW6Oe8Y8rsdR5TruWy3vZW1fRzYIYQzX5nl6', 2, 'Cleaner Two', '9876500002', 'cleaner2@example.com');

-- =============================
-- TOILETS
-- =============================
INSERT INTO toilets (id, name, address, lat, lng, type, status, supervisor_id)
VALUES
(1, 'Central Park Toilet', 'Near Gate 1, Central Park, City A', 12.9716, 77.5946, 'unisex', 'active', 1),
(2, 'Bus Stand Toilet', 'Main Bus Stand, City A', 12.9762, 77.6033, 'male', 'active', 1),
(3, 'Railway Station Toilet', 'Platform 3, City A Railway Station', 12.9821, 77.6078, 'female', 'active', 1);

-- =============================
-- ASSIGN CLEANERS TO TOILETS
-- (toilet_id, cleaner_id) in mapping table if you have one, or in toilets if stored as FK
-- =============================
UPDATE toilets SET cleaner_id = 2 WHERE id = 1;
UPDATE toilets SET cleaner_id = 3 WHERE id = 2;

-- =============================
-- TOILET IMAGES
-- =============================
INSERT INTO toilet_images (id, toilet_id, image_url) VALUES
(1, 1, 'https://example.com/images/toilet1.jpg'),
(2, 2, 'https://example.com/images/toilet2.jpg'),
(3, 3, 'https://example.com/images/toilet3.jpg');

-- =============================
-- FEEDBACK (Anonymous + User)
-- =============================
INSERT INTO feedbacks (id, toilet_id, user_id, rating, comment, created_at) VALUES
(1, 1, NULL, 5, 'Very clean and well maintained.', NOW()),
(2, 2, NULL, 3, 'Needs better cleaning in the afternoon.', NOW()),
(3, 1, 2, 4, 'Cleaned properly by cleaner one.', NOW());

-- =============================
-- CLEANING REPORTS
-- =============================
INSERT INTO cleaning_reports (id, toilet_id, cleaner_id, schedule_id, status, notes, supervisor_id, supervisor_remarks, report_time)
VALUES
(1, 1, 2, NULL, 'Cleaned', 'All good in the morning shift.', 1, 'Approved', NOW()),
(2, 2, 3, NULL, 'Not Cleaned', 'Water shortage issue.', 1, 'Rejected - Fix water issue', NOW());

-- =============================
-- CLEANING IMAGES
-- =============================
INSERT INTO cleaning_images (id, report_id, type, image_url) VALUES
(1, 1, 'before', 'https://example.com/images/toilet1_before.jpg'),
(2, 1, 'after', 'https://example.com/images/toilet1_after.jpg'),
(3, 2, 'before', 'https://example.com/images/toilet2_before.jpg');

-- =============================
-- INVENTORY REQUESTS
-- =============================
INSERT INTO inventory_requests (id, toilet_id, cleaner_id, items, notes, status, supervisor_id, created_at)
VALUES
(1, 1, 2, '5x Toilet Paper, 2x Cleaning Liquid', 'Need refill urgently', 'pending', 1, NOW()),
(2, 2, 3, '3x Soap, 1x Mop', 'Stock running low', 'approved', 1, NOW());

-- =============================
-- DAMAGE REPORTS
-- =============================
INSERT INTO damage_reports (id, toilet_id, cleaner_id, description, status, reported_at)
VALUES
(1, 1, 2, 'Broken tap in wash basin.', 'pending', NOW()),
(2, 2, 3, 'Light bulb not working.', 'resolved', NOW());
