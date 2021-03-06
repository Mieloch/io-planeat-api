INSERT INTO `recipes` VALUES (1,'EASY','Makaron z kurczakiem i szpinakiem',20);
INSERT INTO `products` VALUES (1,99,0,1,'Pierś z kurczaka',21),(2,371,75,1,'Makaron',13),(3,39,9,0.1,'Cebula',1.1),(4,148,33,0.5,'Czosnek',6),(5,23,3.6,0.4,'Szpinak',2.9),(6,186,3.6,18,'Śmietana',2.5);
INSERT INTO `ingredients` VALUES (1,400,'GRAM',1),(2,200,'GRAM',2),(3,2,'WHOLE',3),(4,2,'PIECE',4),(5,600,'GRAM',5),(6,300,'GRAM',6);
INSERT INTO `recipes_ingredients` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6);
INSERT INTO `instruction_steps` VALUES (1,'Kurczaka kroimy na niewielkie kawałki i wrzucamy na patelnię. Smażymy przez 2-3 minuty.',1,1),(2,'Następnie dodajemy cebulę oraz czosnek (pokrojone w kostkę). Smażymy 5-6 minut.',2,1),(3,'Dodajemy śmietanę, przyprawy i dusimy 2-3 minuty.',3,1),(4,'Następnie dodajemy umyty szpinak, dusimy 2-3 minuty, dokładnie mieszamy. W międzyczasie gotujemy makaron.',4,1),(5,'Ugotowany makaron łączymy z sosem, dobrze mieszamy.',5,1);
INSERT INTO `users` VALUES (1,'undefined','null','some@gmail.com'), (2,'adam','pass','adam@wp.pl'), (3,'brajan','haslo','brajanek@gmail.com');
INSERT INTO `planeat`.`users_ingredients` (`user_id`, `ingredient_id`) VALUES ('1', '1');
INSERT INTO `planeat`.`users_ingredients` (`user_id`, `ingredient_id`) VALUES ('1', '2');
