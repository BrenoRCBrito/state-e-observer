package com.brenobrito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

class NotificacaoTest
{

  @Test
  void deveNotificarOClienteQuandoOCarroMudaDeEstado()
  {
    Carro carro = new Carro("ABC1D23");
    Cliente cliente = new Cliente("Breno");
    cliente.acompanhar(carro);

    carro.reservado();

    assertEquals("Breno, o carro ABC1D23 esta Reservado", cliente.getUltimaNotificacao());
  }

  @Test
  void deveNotificarTodosOsObservadoresNaMesmaTransicao()
  {
    Carro carro = new Carro("ABC1D23");
    Cliente cliente = new Cliente("Breno");
    Oficina oficina = new Oficina();
    PainelDaFrota painel = new PainelDaFrota();
    cliente.acompanhar(carro);
    oficina.acompanhar(carro);
    painel.acompanhar(carro);

    carro.emManutencao();

    assertEquals("Breno, o carro ABC1D23 esta EmManutencao", cliente.getUltimaNotificacao());
    assertEquals(1, oficina.getOrdensAbertas());
    assertEquals(List.of("EmManutencao"), painel.getHistorico());
  }

  @Test
  void naoDeveNotificarQuemNaoAcompanhaOCarro()
  {
    Carro carro = new Carro("ABC1D23");
    Cliente cliente = new Cliente("Breno");

    carro.reservado();

    assertNull(cliente.getUltimaNotificacao());
  }

  @Test
  void naoDeveNotificarQuandoATransicaoEhRecusada()
  {
    Carro carro = new Carro("ABC1D23");
    Cliente cliente = new Cliente("Breno");
    PainelDaFrota painel = new PainelDaFrota();
    cliente.acompanhar(carro);
    painel.acompanhar(carro);

    assertThrows(RuntimeException.class, carro::alugado);

    assertNull(cliente.getUltimaNotificacao());
    assertEquals(List.of(), painel.getHistorico());
  }

  @Test
  void deveRegistrarNoPainelTodosOsEstadosPorQuePassou()
  {
    Carro carro = new Carro("ABC1D23");
    PainelDaFrota painel = new PainelDaFrota();
    painel.acompanhar(carro);

    carro.reservado();
    carro.alugado();
    carro.emManutencao();
    carro.disponivel();

    assertEquals(List.of("Reservado", "Alugado", "EmManutencao", "Disponivel"), painel.getHistorico());
  }

  @Test
  void oficinaSoDeveAbrirOrdemQuandoOCarroEntraEmManutencao()
  {
    Carro carro = new Carro("ABC1D23");
    Oficina oficina = new Oficina();
    oficina.acompanhar(carro);

    carro.reservado();
    carro.alugado();
    carro.emManutencao();
    carro.disponivel();
    carro.emManutencao();

    assertEquals(2, oficina.getOrdensAbertas());
  }

  @Test
  void deveNotificarApenasOsObservadoresDoCarroQueMudou()
  {
    Carro primeiro = new Carro("ABC1D23");
    Carro segundo = new Carro("XYZ9W87");
    Cliente doPrimeiro = new Cliente("Breno");
    Cliente doSegundo = new Cliente("Ana");
    doPrimeiro.acompanhar(primeiro);
    doSegundo.acompanhar(segundo);

    primeiro.reservado();

    assertEquals("Breno, o carro ABC1D23 esta Reservado", doPrimeiro.getUltimaNotificacao());
    assertNull(doSegundo.getUltimaNotificacao());
  }
}
