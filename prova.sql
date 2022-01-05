-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 05-Jan-2022 às 20:55
-- Versão do servidor: 5.7.31
-- versão do PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `prova`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) COLLATE utf8_bin NOT NULL,
  `dataNascimento` date NOT NULL,
  `tipo` int(11) NOT NULL,
  `estadoCivil` int(11) NOT NULL,
  `filhos` tinyint(1) NOT NULL,
  `profissao` varchar(30) COLLATE utf8_bin NOT NULL,
  `sexo` int(11) NOT NULL,
  `endereco` varchar(100) COLLATE utf8_bin NOT NULL,
  `bairro` varchar(100) COLLATE utf8_bin NOT NULL,
  `cidade` varchar(50) COLLATE utf8_bin NOT NULL,
  `cep` int(11) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`codigo`, `nome`, `dataNascimento`, `tipo`, `estadoCivil`, `filhos`, `profissao`, `sexo`, `endereco`, `bairro`, `cidade`, `cep`) VALUES
(1, 'marco', '2022-01-05', 0, 0, 0, 'programador', 0, 'rua', 'bairro', 'duque de caxias', 25240130),
(2, 'pedro', '2022-01-05', 0, 0, 1, 'nada', 0, '1', '2', '3', 11111111),
(4, 'jose', '2022-01-05', 0, 0, 1, 'desempregado', 0, 'rua', 'bairro', 'cidade', 11111111);

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefones`
--

DROP TABLE IF EXISTS `telefones`;
CREATE TABLE IF NOT EXISTS `telefones` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `codigoCliente` int(11) NOT NULL,
  `telefone` int(11) NOT NULL,
  `tipoTelefone` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_TELEFONE_CLIENTES` (`codigoCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `telefones`
--

INSERT INTO `telefones` (`codigo`, `codigoCliente`, `telefone`, `tipoTelefone`) VALUES
(1, 4, 36547345, 0),
(2, 4, 36547345, 1);

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `telefones`
--
ALTER TABLE `telefones`
  ADD CONSTRAINT `FK_TELEFONE_CLIENTES` FOREIGN KEY (`codigoCliente`) REFERENCES `clientes` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
