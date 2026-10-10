package com.brenobrito;

public class CarroEstadoReservado extends CarroEstado
{

  private static final CarroEstadoReservado singleton = new CarroEstadoReservado();

  private CarroEstadoReservado()
  {
  }

  public static CarroEstadoReservado getInstance()
  {
    return singleton;
  }

  @Override
  public String getNome()
  {
    return "Reservado";
  }

  @Override
  public void alugado(Carro carro)
  {
    carro.setEstado(CarroEstadoAlugado.getInstance());
  }

  @Override
  public void disponivel(Carro carro)
  {
    carro.setEstado(CarroEstadoDisponivel.getInstance());
  }
}
