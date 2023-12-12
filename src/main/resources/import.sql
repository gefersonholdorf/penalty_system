INSERT INTO tb_group(name) VALUES('Grupo A');
INSERT INTO tb_group(name) VALUES('Grupo B');

INSERT INTO tb_team(name, gymnasium, pot, group_id) VALUES('Central E.C', 'Cruz e Souza', 9, 1);
INSERT INTO tb_team(name, gymnasium, pot, group_id) VALUES('Botafogo', 'Cruz e Souza', 8, 2);
INSERT INTO tb_team(name, gymnasium, pot, group_id) VALUES('Inter', 'Russo', 7, 2);
INSERT INTO tb_team(name, gymnasium, pot, group_id) VALUES('União São João', 'São João', 5, 1);
INSERT INTO tb_team(name, gymnasium, pot, group_id) VALUES('Mitos', 'Alto Benedito', 5, 1);
INSERT INTO tb_team(name, gymnasium, pot, group_id) VALUES('Cosmos', 'Santa Maria', 4, 2);

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

INSERT INTO tb_match(data, home_team_id, visiting_team_id, group_id) VALUES('2023-12-11 20:01:23', 1, 4, 1);
INSERT INTO tb_match(data, home_team_id, visiting_team_id, group_id) VALUES('2023-12-11 20:01:23', 2, 6, 2);
INSERT INTO tb_match(data, home_team_id, visiting_team_id, group_id) VALUES('2023-12-11 20:01:23', 4, 5, 1);
INSERT INTO tb_match(data, home_team_id, visiting_team_id, group_id) VALUES('2023-12-11 20:01:23', 6, 3, 2);
INSERT INTO tb_match(data, home_team_id, visiting_team_id, group_id) VALUES('2023-12-11 20:01:23', 5, 1, 1);
INSERT INTO tb_match(data, home_team_id, visiting_team_id, group_id) VALUES('2023-12-11 20:01:23', 3, 2, 2);
