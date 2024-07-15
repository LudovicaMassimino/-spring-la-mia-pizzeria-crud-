INSERT INTO  db_pizzeria.pizza (descrizione, foto, nome, price)
values ("pomodoro san marzano e mozzarella fior di latte", "/img/margherita.jpeg", "Margherita", "5");

SELECT  *
from db_pizzeria.pizza p ;

DELETE FROM db_pizzeria.pizza
WHERE id=2;

DELETE FROM db_pizzeria.pizza
WHERE id=1;

DELETE FROM db_pizzeria.pizza
WHERE id=3;

INSERT INTO  db_pizzeria.pizza (descrizione, foto, nome, price)
values ("pomodoro san marzano e mozzarella fior di latte", "/img/margherita.jpeg", "Margherita", "5"),
("pomodoro, mozzarella, melanzane fritte, ricotta salata, basilico", "", "Norma", "8"),
("pesto di pistacchio, mozzarella, mortadella, crema di pistacchio, granella di pistacchio", "", "Pistacchiosa", "10"),
("pesto di basilico, datterino confit, basilico", "", "Basilico", "7");

INSERT INTO  db_pizzeria.pizza (descrizione, foto, nome, price)
values ("pomodoro, mozzarella, melanzane fritte, ricotta salata, basilico", "", "Norma", "8");


