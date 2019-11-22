-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 05-Nov-2019 às 21:14
-- Versão do servidor: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbinfox`
--
CREATE DATABASE IF NOT EXISTS `dbinfox` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `dbinfox`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbclientes`
--

CREATE TABLE `tbclientes` (
  `idcli` int(11) NOT NULL,
  `nomecli` varchar(50) NOT NULL,
  `endcli` varchar(100) NOT NULL,
  `numcli` varchar(15) NOT NULL,
  `complcli` varchar(30) DEFAULT NULL,
  `bairrocli` varchar(25) NOT NULL,
  `cidadecli` varchar(25) NOT NULL,
  `estadocli` varchar(15) NOT NULL,
  `celcli` varchar(15) NOT NULL,
  `fixocli` varchar(15) DEFAULT NULL,
  `emailcli` varchar(50) DEFAULT NULL,
  `cep` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbclientes`
--

INSERT INTO `tbclientes` (`idcli`, `nomecli`, `endcli`, `numcli`, `complcli`, `bairrocli`, `cidadecli`, `estadocli`, `celcli`, `fixocli`, `emailcli`, `cep`) VALUES
(1, 'Mauricio Davel', 'Av. Hugo Musso', '1163', 'AP-502', 'Praia da Costa', 'Vila Velha', 'ES', '2799822-4697', '273299-3085', 'mauriciodavel@hotmail.com', '29.101-281'),
(3, 'NIKOLAS', 'HUGO MUSSO', '1149', 'AP 501', 'PRAIA DA COSTA', 'VILA VELHA', 'ES', '99999-9999', '3333-3333', 'MDAVEL@FINDES.ORG.BR', '29.101-280'),
(4, 'ANTELMO  PADOANI DAVEL', 'Rua Herman Stern', '1149', 'AP 501', 'Colina de Laranjeiras ', 'Serra', 'ES', '27 99899-2633', '27 3333-3333', 'LEO2006PADOANI@HOTMAIL.COM', '29167081'),
(5, 'JAMILLY DAVEL PADOANI', 'Avenida Hugo Musso', '1149', 'AP 501', 'Praia da Costa', 'Vila Velha', 'ES', '27 3299-3085', '27 99999-9999', 'JPADOANI@HOTMAIL.COM', '29101280');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbos`
--

CREATE TABLE `tbos` (
  `os` int(11) NOT NULL,
  `data_os` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tipo` varchar(15) NOT NULL,
  `situacao` varchar(20) NOT NULL,
  `equipamento` varchar(150) NOT NULL,
  `defeito` varchar(150) NOT NULL,
  `servico` varchar(150) DEFAULT NULL,
  `tecnico` varchar(30) DEFAULT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  `idcli` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbos`
--

INSERT INTO `tbos` (`os`, `data_os`, `tipo`, `situacao`, `equipamento`, `defeito`, `servico`, `tecnico`, `valor`, `idcli`) VALUES
(1, '2018-01-05 21:24:26', 'OS', 'Entrega OK', 'Notebook', 'Não liga', 'Troca da fonte', 'Mauricio', '200.00', 1),
(3, '2018-01-16 11:34:26', 'Orçamento', 'Na bancada', 'Notebook DELL', 'Travando sistema operacional', 'formatar e instalar sistema operacional windows 7', 'Mauricio Davel', '180.00', 4),
(4, '2018-01-20 23:27:32', 'OS', 'Aguardando Aprovação', 'Impressora Lexmark X83', 'Não puxa papel', 'Trocar sensor de papel', 'Mauricio Davel', '120.00', 4),
(5, '2019-04-15 17:49:31', 'Orçamento', 'Na bancada', 'Celular Samsung', 'Tela Trincada', 'Trocar display', 'Mauricio', '90.00', 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbusuarios`
--

CREATE TABLE `tbusuarios` (
  `iduser` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `fone` varchar(15) DEFAULT NULL,
  `login` varchar(15) NOT NULL,
  `senha` varchar(15) NOT NULL,
  `perfil` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbusuarios`
--

INSERT INTO `tbusuarios` (`iduser`, `usuario`, `fone`, `login`, `senha`, `perfil`) VALUES
(2, 'Administrador', '273298-7800', 'admin', 'admin', 'admin'),
(3, 'Eric Xavier', '99999-9999', 'xavier', '123456', 'user'),
(4, 'Catia Buzelli', '27 99999-9999', 'cbuzelli', '123456', 'user'),
(5, 'Sarah Signorelli', '27 99999-9999', 'ssignorelli', '123456', 'user'),
(2919, 'Mauricio Davel', '2799822-4697', 'mdavel', 'mdavel7820', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbclientes`
--
ALTER TABLE `tbclientes`
  ADD PRIMARY KEY (`idcli`);

--
-- Indexes for table `tbos`
--
ALTER TABLE `tbos`
  ADD PRIMARY KEY (`os`),
  ADD KEY `idcli` (`idcli`);

--
-- Indexes for table `tbusuarios`
--
ALTER TABLE `tbusuarios`
  ADD PRIMARY KEY (`iduser`),
  ADD UNIQUE KEY `login` (`login`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbclientes`
--
ALTER TABLE `tbclientes`
  MODIFY `idcli` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbos`
--
ALTER TABLE `tbos`
  MODIFY `os` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `tbos`
--
ALTER TABLE `tbos`
  ADD CONSTRAINT `tbos_ibfk_1` FOREIGN KEY (`idcli`) REFERENCES `tbclientes` (`idcli`);
--
