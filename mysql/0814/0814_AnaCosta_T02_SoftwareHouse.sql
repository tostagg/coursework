-- 1) criar base de dados bdprojetos
create database bdprojetos;
use bdprojetos;

-- 2) criação das tabelas e respetivos campos
create table projetos (
		p		int auto_increment,
        df		date not null,
		primary key (p)
);

create table cargos (
		c 		varchar(2) not null,
        cargo	varchar(20) not null,
        primary key (c)
);

create table funcionarios (
		f		int,
        nome	varchar(50) not null,
		c		varchar(2) not null,
        primary key (c),
        foreign key (c)
				references cargos(c)
				on update cascade
);

create table envolvidos (
		p		int not null,
        f 		int not null,
        primary key (p, f),
        foreign key (p)
				references projetos (p)
                on update cascade,
		foreign key (f)
				references funcionarios (f)
				on update cascade
);

-- 3) introduzir dados nas tabelas criadas

insert into projetos (df)
	values 
        ('2015-10-19'), 
        ('2015-12-20'), 
        ('2015-11-14'), 
        ('2016-01-23'), 
        ('2016-03-28');
        
insert into cargos (c, cargo)
	values
		('PR', 'Programador'), 
        ('AL', 'Analista'), 
        ('WD', 'Web Designer');
        
insert into funcionarios
	values
		('3', 'Ana Pinto', 'PR'), 
        ('1', 'Rui Antunes', 'PR'), 
        ('2', 'Miguel Ferreira', 'AL'), 
        ('12', 'Sónia Oliveira', 'WD');
        
insert into envolvidos (p, f)
	values
		('1', '3'), 
        ('1', '1'), 
        ('1', '2'), 
        ('2', '1'), 
        ('2', '12'), 
        ('3', '2'), 
        ('3', '12'), 
        ('4', '3'), 
        ('4', '2'), 
        ('4', '12'), 
        ('5', '1'), 
        ('5','2');
		
-- 4. a)
ALTER TABLE projetos 
	ADD descricao VARCHAR(100);
ALTER TABLE projetos 
	ADD di DATE;

delimiter //
create trigger verificar_data
	before insert on projetos
	for each row
	begin
		if new.di < new.df then 
			signal sqlstate '45000'
			set message_text = 'Erro!';
		end if;
	end //
delimiter ;

-- 4. b)
alter table funcionarios
	add email varchar(100) unique;
update funcionarios
	set email = concat(replace(lower(nome),' ', '.'), '@softwarehouse.pt');

-- 4. c)
alter table projetos
	add responsavel varchar(3),
	add constraint fk_responsavel foreign key (responsavel) references funcionarios(f);

-- 4. d)
alter table funcionarios
	add column preco_dia decimal(5, 2);

-- 5. a) total de funcionários por projeto
select p, sum(f) as total_funcionarios
	from envolvidos
		group by p;

-- 5. b) total de projetos por funcionário
select 
    funcionarios.nome, COUNT(envolvidos.p) as total_projetos
from
    envolvidos
		left join
		funcionarios on envolvidos.f = funcionarios.f
group by nome;


-- 5. c) total de funcionários por cargo
select 
    cargos.cargo as cargo, 
    count(funcionarios.c) as total_funcionarios
from
	funcionarios
		left join 
		cargos on cargos.c = funcionarios.c
group by cargos.cargo;

-- 5. d)  atualizar tabela projetos
update projetos 
	set 
		descricao = 'Site CMS',
		di = '2015-09-01'
			where
				p = 1;

update projetos 
	set 
		descricao = 'Sistema de Cobrança',
		di = '2015-11-20'
			where
				p = 2;

update projetos 
	set 
		descricao = 'Controlo de Assiduidade',
		di = '2015-11-14'
			where
				p = 3;

update projetos 
	set 
		descricao = 'Site CML',
		di = '2015-12-12'
			where
				p = 4;

update projetos 
	set 
		descricao = 'Licenciamento',
		di = '2016-01-03'
			where
				p = 5;

-- 5. e) atualizar tabela funcionários
update funcionarios 
	set 
		preco_dia = '52.5'
			where
				f = 3;

update funcionarios 
	set 
		preco_dia = '50'
			where
				f = 1;
   
update funcionarios 
	set 
		preco_dia = '75'
			where
				f = 2;
    
update funcionarios 
	set 
		preco_dia = '45'
			where
				f = 12;

-- 5. f) calcular montante gasto em cada cada projeto
select
	projetos.p,
    descricao,
    di,
    df,
    datediff(df, di) as total_dias,
    sum(funcionarios.preco_dia * datediff(df,di)) as total_gasto
from
	projetos
		join envolvidos on projetos.p = envolvidos.p
        join funcionarios on envolvidos.f = funcionarios.f
group by
	projetos.p;