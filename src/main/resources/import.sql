INSERT INTO tb_championship(name) VALUES ('Liga Benedito de Penaltis');

INSERT INTO tb_group(name, championship_id) VALUES('Grupo A', 1);
INSERT INTO tb_group(name, championship_id) VALUES('Grupo B', 1);

INSERT INTO tb_final_phase(name, championship_id) VALUES('Final Phase', 1)

INSERT INTO tb_team(name, gymnasium, pot) VALUES('Central E.C', 'Cruz e Souza', 9);
INSERT INTO tb_team(name, gymnasium, pot) VALUES('Botafogo', 'Cruz e Souza', 8);
INSERT INTO tb_team(name, gymnasium, pot) VALUES('Inter', 'Russo', 7);
INSERT INTO tb_team(name, gymnasium, pot) VALUES('União São João', 'São João', 5);
INSERT INTO tb_team(name, gymnasium, pot) VALUES('Mitos', 'Alto Benedito', 5);
INSERT INTO tb_team(name, gymnasium, pot) VALUES('Cosmos', 'Santa Maria', 4);
INSERT INTO tb_team(name, gymnasium, pot) VALUES('Real Liberdade', 'Liberdade', 5);
INSERT INTO tb_team(name, gymnasium, pot) VALUES('Centro', 'Cruz e Souza', 6);

INSERT INTO tb_classification_team (position, points, balance, victories, draws, defeats, goals_for, own_goals, games, team_id, group_id) VALUES (0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO tb_classification_team (position, points, balance, victories, draws, defeats, goals_for, own_goals, games, team_id, group_id) VALUES (0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2);
INSERT INTO tb_classification_team (position, points, balance, victories, draws, defeats, goals_for, own_goals, games, team_id, group_id) VALUES (0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2);
INSERT INTO tb_classification_team (position, points, balance, victories, draws, defeats, goals_for, own_goals, games, team_id, group_id) VALUES (0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 1);
INSERT INTO tb_classification_team (position, points, balance, victories, draws, defeats, goals_for, own_goals, games, team_id, group_id) VALUES (0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 1);
INSERT INTO tb_classification_team (position, points, balance, victories, draws, defeats, goals_for, own_goals, games, team_id, group_id) VALUES (0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 2);
INSERT INTO tb_classification_team (position, points, balance, victories, draws, defeats, goals_for, own_goals, games, team_id, group_id) VALUES (0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 1);
INSERT INTO tb_classification_team (position, points, balance, victories, draws, defeats, goals_for, own_goals, games, team_id, group_id) VALUES (0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 2);


INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Alexandre', 8, 10, 0, 1);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Filipe', 9, 7, 1, 1);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Hugo', 8, 8, 1, 1);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Luciano', 7, 10, 0, 2);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Freitas', 8, 7, 1, 2);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Iago', 6, 10, 1, 2);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Renato', 9, 5, 0, 3);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Paulo', 7, 7, 1, 3);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Peixe', 8, 8, 1, 3);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Café', 7, 8, 0, 4);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Tiago', 5, 6, 1, 4);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Guilherme', 6, 6, 1, 4);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Quico', 5, 6, 0, 5);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Nanico', 8, 5, 1, 5);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Fernandes', 4, 1, 1, 5);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Gabriel', 6, 5, 0, 6);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Cássio', 5, 6, 1, 6);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Paulinho', 7, 5, 1, 6);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Cesar', 7, 4, 0, 7);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Felippe', 8, 6, 1, 7);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Diogo', 6, 6, 1, 7);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Lucas', 7, 8, 0, 8);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Fabinho', 8, 4, 1, 8);
INSERT INTO tb_athlete(name, pot, hab, position, team_id) VALUES('Yuri', 5, 7, 1, 8);