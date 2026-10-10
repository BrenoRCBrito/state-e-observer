package com.brenobrito;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CarroTest
{

  @Test
  void deveComecarDisponivel()
  {
    assertSame(CarroEstadoDisponivel.getInstance(), new Carro("ABC1D23").getEstado());
  }

  @Test
  void naoDeveDisponibilizarQuandoDisponivel()
  {
    Carro carro = new Carro("ABC1D23");

    assertThrows(RuntimeException.class, carro::disponivel);

    assertSame(CarroEstadoDisponivel.getInstance(), carro.getEstado());
  }

  @Test
  void deveReservarQuandoDisponivel()
  {
    Carro carro = new Carro("ABC1D23");

    carro.reservado();

    assertSame(CarroEstadoReservado.getInstance(), carro.getEstado());
  }

  @Test
  void naoDeveAlugarQuandoDisponivel()
  {
    Carro carro = new Carro("ABC1D23");

    assertThrows(RuntimeException.class, carro::alugado);

    assertSame(CarroEstadoDisponivel.getInstance(), carro.getEstado());
  }

  @Test
  void deveEnviarParaManutencaoQuandoDisponivel()
  {
    Carro carro = new Carro("ABC1D23");

    carro.emManutencao();

    assertSame(CarroEstadoEmManutencao.getInstance(), carro.getEstado());
  }

  @Test
  void deveInativarQuandoDisponivel()
  {
    Carro carro = new Carro("ABC1D23");

    carro.inativo();

    assertSame(CarroEstadoInativo.getInstance(), carro.getEstado());
  }

  @Test
  void deveDisponibilizarQuandoReservado()
  {
    Carro carro = new Carro("ABC1D23");
    carro.reservado();

    carro.disponivel();

    assertSame(CarroEstadoDisponivel.getInstance(), carro.getEstado());
  }

  @Test
  void naoDeveReservarQuandoReservado()
  {
    Carro carro = new Carro("ABC1D23");
    carro.reservado();

    assertThrows(RuntimeException.class, carro::reservado);

    assertSame(CarroEstadoReservado.getInstance(), carro.getEstado());
  }

  @Test
  void deveAlugarQuandoReservado()
  {
    Carro carro = new Carro("ABC1D23");
    carro.reservado();

    carro.alugado();

    assertSame(CarroEstadoAlugado.getInstance(), carro.getEstado());
  }

  @Test
  void naoDeveEnviarParaManutencaoQuandoReservado()
  {
    Carro carro = new Carro("ABC1D23");
    carro.reservado();

    assertThrows(RuntimeException.class, carro::emManutencao);

    assertSame(CarroEstadoReservado.getInstance(), carro.getEstado());
  }

  @Test
  void naoDeveInativarQuandoReservado()
  {
    Carro carro = new Carro("ABC1D23");
    carro.reservado();

    assertThrows(RuntimeException.class, carro::inativo);

    assertSame(CarroEstadoReservado.getInstance(), carro.getEstado());
  }

  @Test
  void deveDisponibilizarQuandoAlugado()
  {
    Carro carro = new Carro("ABC1D23");
    carro.reservado();
    carro.alugado();

    carro.disponivel();

    assertSame(CarroEstadoDisponivel.getInstance(), carro.getEstado());
  }

  @Test
  void naoDeveReservarQuandoAlugado()
  {
    Carro carro = new Carro("ABC1D23");
    carro.reservado();
    carro.alugado();

    assertThrows(RuntimeException.class, carro::reservado);

    assertSame(CarroEstadoAlugado.getInstance(), carro.getEstado());
  }

  @Test
  void naoDeveAlugarQuandoAlugado()
  {
    Carro carro = new Carro("ABC1D23");
    carro.reservado();
    carro.alugado();

    assertThrows(RuntimeException.class, carro::alugado);

    assertSame(CarroEstadoAlugado.getInstance(), carro.getEstado());
  }

  @Test
  void deveEnviarParaManutencaoQuandoAlugado()
  {
    Carro carro = new Carro("ABC1D23");
    carro.reservado();
    carro.alugado();

    carro.emManutencao();

    assertSame(CarroEstadoEmManutencao.getInstance(), carro.getEstado());
  }

  @Test
  void naoDeveInativarQuandoAlugado()
  {
    Carro carro = new Carro("ABC1D23");
    carro.reservado();
    carro.alugado();

    assertThrows(RuntimeException.class, carro::inativo);

    assertSame(CarroEstadoAlugado.getInstance(), carro.getEstado());
  }

  @Test
  void deveDisponibilizarQuandoEmManutencao()
  {
    Carro carro = new Carro("ABC1D23");
    carro.emManutencao();

    carro.disponivel();

    assertSame(CarroEstadoDisponivel.getInstance(), carro.getEstado());
  }

  @Test
  void naoDeveReservarQuandoEmManutencao()
  {
    Carro carro = new Carro("ABC1D23");
    carro.emManutencao();

    assertThrows(RuntimeException.class, carro::reservado);

    assertSame(CarroEstadoEmManutencao.getInstance(), carro.getEstado());
  }

  @Test
  void naoDeveAlugarQuandoEmManutencao()
  {
    Carro carro = new Carro("ABC1D23");
    carro.emManutencao();

    assertThrows(RuntimeException.class, carro::alugado);

    assertSame(CarroEstadoEmManutencao.getInstance(), carro.getEstado());
  }

  @Test
  void naoDeveEnviarParaManutencaoQuandoEmManutencao()
  {
    Carro carro = new Carro("ABC1D23");
    carro.emManutencao();

    assertThrows(RuntimeException.class, carro::emManutencao);

    assertSame(CarroEstadoEmManutencao.getInstance(), carro.getEstado());
  }

  @Test
  void deveInativarQuandoEmManutencao()
  {
    Carro carro = new Carro("ABC1D23");
    carro.emManutencao();

    carro.inativo();

    assertSame(CarroEstadoInativo.getInstance(), carro.getEstado());
  }

  @Test
  void naoDeveDisponibilizarQuandoInativo()
  {
    Carro carro = new Carro("ABC1D23");
    carro.inativo();

    assertThrows(RuntimeException.class, carro::disponivel);

    assertSame(CarroEstadoInativo.getInstance(), carro.getEstado());
  }

  @Test
  void naoDeveReservarQuandoInativo()
  {
    Carro carro = new Carro("ABC1D23");
    carro.inativo();

    assertThrows(RuntimeException.class, carro::reservado);

    assertSame(CarroEstadoInativo.getInstance(), carro.getEstado());
  }

  @Test
  void naoDeveAlugarQuandoInativo()
  {
    Carro carro = new Carro("ABC1D23");
    carro.inativo();

    assertThrows(RuntimeException.class, carro::alugado);

    assertSame(CarroEstadoInativo.getInstance(), carro.getEstado());
  }

  @Test
  void naoDeveEnviarParaManutencaoQuandoInativo()
  {
    Carro carro = new Carro("ABC1D23");
    carro.inativo();

    assertThrows(RuntimeException.class, carro::emManutencao);

    assertSame(CarroEstadoInativo.getInstance(), carro.getEstado());
  }

  @Test
  void naoDeveInativarQuandoInativo()
  {
    Carro carro = new Carro("ABC1D23");
    carro.inativo();

    assertThrows(RuntimeException.class, carro::inativo);

    assertSame(CarroEstadoInativo.getInstance(), carro.getEstado());
  }
}
