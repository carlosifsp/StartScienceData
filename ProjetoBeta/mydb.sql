-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 21-Nov-2018 às 20:33
-- Versão do servidor: 10.1.36-MariaDB
-- versão do PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mydb`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `animais`
--

CREATE TABLE `animais` (
  `idAnimais` int(11) NOT NULL,
  `apelido` varchar(50) NOT NULL,
  `Especie` varchar(45) NOT NULL,
  `Idade` tinyint(4) NOT NULL,
  `Genero` tinyint(4) NOT NULL,
  `Drogas` tinyint(1) NOT NULL,
  `Exercicio` tinyint(1) NOT NULL,
  `VO2max_idVO2max` int(11) DEFAULT NULL,
  `Histologia_idHistologia` int(11) DEFAULT NULL,
  `Hemodinamica_idHemodinamica` int(11) DEFAULT NULL,
  `Pesos_idPesos` int(11) DEFAULT NULL,
  `Exame_Sangue_idExame_Sangue` int(11) DEFAULT NULL,
  `Biologia_Molecular_idBiologia_Molecular` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `biologia_molecular`
--

CREATE TABLE `biologia_molecular` (
  `idBiologia_Molecular` int(11) NOT NULL,
  `AKT1` float DEFAULT NULL,
  `p-AKT1` float DEFAULT NULL,
  `GSK3-b` float DEFAULT NULL,
  `p-GSK3-b` float DEFAULT NULL,
  `IL-6` float DEFAULT NULL,
  `IL-8` float DEFAULT NULL,
  `IL-10` float DEFAULT NULL,
  `NCX` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `exame_sangue`
--

CREATE TABLE `exame_sangue` (
  `idExame_Sangue` int(11) NOT NULL,
  `SOD` float DEFAULT NULL,
  `Catalase` float DEFAULT NULL,
  `Glutationa` float DEFAULT NULL,
  `MDA` float DEFAULT NULL,
  `CK` float DEFAULT NULL,
  `CKMB` float DEFAULT NULL,
  `Troponina I` float DEFAULT NULL,
  `Troponina T` float DEFAULT NULL,
  `Lactato` float DEFAULT NULL,
  `NOS` float DEFAULT NULL,
  `Citocinas` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `hemodinamica`
--

CREATE TABLE `hemodinamica` (
  `DP_mais` float DEFAULT NULL,
  `DP_menos` float DEFAULT NULL,
  `FC` float DEFAULT NULL,
  `PS_max` float DEFAULT NULL,
  `PS_min` float DEFAULT NULL,
  `idHemodinamica` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `histologia`
--

CREATE TABLE `histologia` (
  `Nucleo` float DEFAULT NULL,
  `Colageno` float DEFAULT NULL,
  `idHistologia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `nivel`
--

CREATE TABLE `nivel` (
  `idNivel` int(11) NOT NULL,
  `Nivel` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pesos`
--

CREATE TABLE `pesos` (
  `Peso_seco_Pulmao` float DEFAULT NULL,
  `Peso_seco_Figado` float DEFAULT NULL,
  `Peso_umido_Pulmao` float DEFAULT NULL,
  `Peso_umido_Figado` float DEFAULT NULL,
  `idPesos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `projeto`
--

CREATE TABLE `projeto` (
  `idProjeto` int(11) NOT NULL,
  `Titulo` varchar(45) NOT NULL,
  `Comite` varchar(45) NOT NULL,
  `Ano` varchar(4) NOT NULL,
  `Universidade_idUniversidade` int(200) NOT NULL,
  `Animais_idAnimais` int(200) DEFAULT NULL,
  `Usuario_idUsuario` int(200) DEFAULT NULL,
  `Nivel_idNivel` int(200) DEFAULT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `universidade`
--

CREATE TABLE `universidade` (
  `idUniversidade` int(11) NOT NULL,
  `Nome` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `Nome` varchar(150) NOT NULL,
  `Sobrenome` varchar(150) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Senha` varchar(45) NOT NULL,
  `DataNascimento` varchar(45) NOT NULL,
  `CPF` varchar(11) NOT NULL,
  `Universidade_idUniversidade` int(11) NOT NULL,
  `Nivel_idNivel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `Nome`, `Sobrenome`, `Email`, `Senha`, `DataNascimento`, `CPF`, `Universidade_idUniversidade`, `Nivel_idNivel`) VALUES
(4, 'Carlos Mario', 'Oliveira Novais', 'oliveiracarlosmario1@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', '1999-03-20', '12803778602', 1, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario_has_projeto`
--

CREATE TABLE `usuario_has_projeto` (
  `Usuario_idUsuario` int(11) NOT NULL,
  `Projeto_idProjeto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `vo2max`
--

CREATE TABLE `vo2max` (
  `VO2max` float DEFAULT NULL,
  `idVO2max` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `animais`
--
ALTER TABLE `animais`
  ADD PRIMARY KEY (`idAnimais`),
  ADD KEY `fk_Animais_VO2max1_idx` (`VO2max_idVO2max`),
  ADD KEY `fk_Animais_Histologia1_idx` (`Histologia_idHistologia`),
  ADD KEY `fk_Animais_Hemodinamica1_idx` (`Hemodinamica_idHemodinamica`),
  ADD KEY `fk_Animais_Pesos1_idx` (`Pesos_idPesos`),
  ADD KEY `fk_Animais_Exame_Sangue1_idx` (`Exame_Sangue_idExame_Sangue`),
  ADD KEY `fk_Animais_Biologia_Molecular1_idx` (`Biologia_Molecular_idBiologia_Molecular`);

--
-- Indexes for table `biologia_molecular`
--
ALTER TABLE `biologia_molecular`
  ADD PRIMARY KEY (`idBiologia_Molecular`);

--
-- Indexes for table `exame_sangue`
--
ALTER TABLE `exame_sangue`
  ADD PRIMARY KEY (`idExame_Sangue`);

--
-- Indexes for table `hemodinamica`
--
ALTER TABLE `hemodinamica`
  ADD PRIMARY KEY (`idHemodinamica`);

--
-- Indexes for table `histologia`
--
ALTER TABLE `histologia`
  ADD PRIMARY KEY (`idHistologia`);

--
-- Indexes for table `nivel`
--
ALTER TABLE `nivel`
  ADD PRIMARY KEY (`idNivel`);

--
-- Indexes for table `pesos`
--
ALTER TABLE `pesos`
  ADD PRIMARY KEY (`idPesos`);

--
-- Indexes for table `projeto`
--
ALTER TABLE `projeto`
  ADD PRIMARY KEY (`idProjeto`,`Universidade_idUniversidade`),
  ADD KEY `fk_Projeto_Universidade1_idx` (`Universidade_idUniversidade`),
  ADD KEY `fk_Projeto_Animais1_idx` (`Animais_idAnimais`),
  ADD KEY `fk_Projeto_Usuario1_idx` (`Usuario_idUsuario`),
  ADD KEY `fk_Projeto_Nivel1_idx` (`Nivel_idNivel`);

--
-- Indexes for table `universidade`
--
ALTER TABLE `universidade`
  ADD PRIMARY KEY (`idUniversidade`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`,`Universidade_idUniversidade`,`Nivel_idNivel`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD KEY `fk_Usuario_Universidade1_idx` (`Universidade_idUniversidade`),
  ADD KEY `fk_Usuario_Nivel1_idx` (`Nivel_idNivel`);

--
-- Indexes for table `usuario_has_projeto`
--
ALTER TABLE `usuario_has_projeto`
  ADD PRIMARY KEY (`Usuario_idUsuario`,`Projeto_idProjeto`),
  ADD KEY `fk_Usuario_has_Projeto_Projeto1_idx` (`Projeto_idProjeto`),
  ADD KEY `fk_Usuario_has_Projeto_Usuario_idx` (`Usuario_idUsuario`);

--
-- Indexes for table `vo2max`
--
ALTER TABLE `vo2max`
  ADD PRIMARY KEY (`idVO2max`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `animais`
--
ALTER TABLE `animais`
  MODIFY `idAnimais` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `biologia_molecular`
--
ALTER TABLE `biologia_molecular`
  MODIFY `idBiologia_Molecular` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `exame_sangue`
--
ALTER TABLE `exame_sangue`
  MODIFY `idExame_Sangue` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hemodinamica`
--
ALTER TABLE `hemodinamica`
  MODIFY `idHemodinamica` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `histologia`
--
ALTER TABLE `histologia`
  MODIFY `idHistologia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nivel`
--
ALTER TABLE `nivel`
  MODIFY `idNivel` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pesos`
--
ALTER TABLE `pesos`
  MODIFY `idPesos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `projeto`
--
ALTER TABLE `projeto`
  MODIFY `idProjeto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `universidade`
--
ALTER TABLE `universidade`
  MODIFY `idUniversidade` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `vo2max`
--
ALTER TABLE `vo2max`
  MODIFY `idVO2max` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `animais`
--
ALTER TABLE `animais`
  ADD CONSTRAINT `fk_Animais_Biologia_Molecular1` FOREIGN KEY (`Biologia_Molecular_idBiologia_Molecular`) REFERENCES `biologia_molecular` (`idBiologia_Molecular`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Animais_Exame_Sangue1` FOREIGN KEY (`Exame_Sangue_idExame_Sangue`) REFERENCES `exame_sangue` (`idExame_Sangue`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Animais_Hemodinamica1` FOREIGN KEY (`Hemodinamica_idHemodinamica`) REFERENCES `hemodinamica` (`idHemodinamica`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Animais_Histologia1` FOREIGN KEY (`Histologia_idHistologia`) REFERENCES `histologia` (`idHistologia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Animais_Pesos1` FOREIGN KEY (`Pesos_idPesos`) REFERENCES `pesos` (`idPesos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Animais_VO2max1` FOREIGN KEY (`VO2max_idVO2max`) REFERENCES `vo2max` (`idVO2max`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `projeto`
--
ALTER TABLE `projeto`
  ADD CONSTRAINT `fk_Projeto_Animais1` FOREIGN KEY (`Animais_idAnimais`) REFERENCES `animais` (`idAnimais`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Projeto_Nivel1` FOREIGN KEY (`Nivel_idNivel`) REFERENCES `nivel` (`idNivel`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Projeto_Universidade1` FOREIGN KEY (`Universidade_idUniversidade`) REFERENCES `universidade` (`idUniversidade`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Projeto_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_Usuario_Nivel1` FOREIGN KEY (`Nivel_idNivel`) REFERENCES `nivel` (`idNivel`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Usuario_Universidade1` FOREIGN KEY (`Universidade_idUniversidade`) REFERENCES `universidade` (`idUniversidade`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `usuario_has_projeto`
--
ALTER TABLE `usuario_has_projeto`
  ADD CONSTRAINT `fk_Usuario_has_Projeto_Projeto1` FOREIGN KEY (`Projeto_idProjeto`) REFERENCES `projeto` (`idProjeto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Usuario_has_Projeto_Usuario` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
