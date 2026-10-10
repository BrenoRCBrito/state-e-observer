package com.brenobrito;

public class CarroEstadoEmManutencao extends CarroEstado
{

  private static final CarroEstadoEmManutencao singleton = new CarroEstadoEmManutencao();

  private CarroEstadoEmManutencao()
  {
  }

  public static CarroEstadoEmManutencao getInstance()
  {
    return singleton;
  }

  @Override
  public String getNome()
  {
    return "EmManutencao";
  }

  @Override
  public void disponivel(Carro carro)
  {
    carro.setEstado(CarroEstadoDisponivel.getInstance());
  }

  @Override
  public void inativo(Carro carro)
  {
    carro.setEstado(CarroEstadoInativo.getInstance());
  }
}
