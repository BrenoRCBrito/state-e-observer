package com.brenobrito;

public class CarroEstadoDisponivel extends CarroEstado
{

  private static final CarroEstadoDisponivel singleton = new CarroEstadoDisponivel();

  private CarroEstadoDisponivel()
  {
  }

  public static CarroEstadoDisponivel getInstance()
  {
    return singleton;
  }

  @Override
  public String getNome()
  {
    return "Disponivel";
  }

  @Override
  public void reservado(Carro carro)
  {
    carro.setEstado(CarroEstadoReservado.getInstance());
  }

  @Override
  public void emManutencao(Carro carro)
  {
    carro.setEstado(CarroEstadoEmManutencao.getInstance());
  }

  @Override
  public void inativo(Carro carro)
  {
    carro.setEstado(CarroEstadoInativo.getInstance());
  }
}
