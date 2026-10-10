package com.brenobrito;

public class CarroEstadoInativo extends CarroEstado
{

  private static final CarroEstadoInativo singleton = new CarroEstadoInativo();

  private CarroEstadoInativo()
  {
  }

  public static CarroEstadoInativo getInstance()
  {
    return singleton;
  }

  @Override
  public String getNome()
  {
    return "Inativo";
  }
}
