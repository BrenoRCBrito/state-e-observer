package com.brenobrito;

public class CarroEstadoAlugado extends CarroEstado
{

  private static final CarroEstadoAlugado singleton = new CarroEstadoAlugado();

  private CarroEstadoAlugado()
  {
  }

  public static CarroEstadoAlugado getInstance()
  {
    return singleton;
  }

  @Override
  public String getNome()
  {
    return "Alugado";
  }

  @Override
  public void disponivel(Carro carro)
  {
    carro.setEstado(CarroEstadoDisponivel.getInstance());
  }

  @Override
  public void emManutencao(Carro carro)
  {
    carro.setEstado(CarroEstadoEmManutencao.getInstance());
  }
}
