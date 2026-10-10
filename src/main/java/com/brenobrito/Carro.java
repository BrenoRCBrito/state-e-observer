package com.brenobrito;

import java.util.Observable;

public class Carro extends Observable
{

  private final String placa;

  private CarroEstado estado = CarroEstadoDisponivel.getInstance();

  public Carro(String placa)
  {
    this.placa = placa;
  }

  public String getPlaca()
  {
    return placa;
  }

  public CarroEstado getEstado()
  {
    return estado;
  }

  void setEstado(CarroEstado estado)
  {
    this.estado = estado;
    setChanged();
    notifyObservers();
  }

  public void disponivel()
  {
    this.estado.disponivel(this);
  }

  public void reservado()
  {
    this.estado.reservado(this);
  }

  public void alugado()
  {
    this.estado.alugado(this);
  }

  public void emManutencao()
  {
    this.estado.emManutencao(this);
  }

  public void inativo()
  {
    this.estado.inativo(this);
  }
}
