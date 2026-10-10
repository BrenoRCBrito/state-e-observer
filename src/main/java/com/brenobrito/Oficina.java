package com.brenobrito;

import java.util.Observable;
import java.util.Observer;

public class Oficina implements Observer
{

  private int ordensAbertas;

  public int getOrdensAbertas()
  {
    return this.ordensAbertas;
  }

  public void acompanhar(Carro carro)
  {
    carro.addObserver(this);
  }

  @Override
  public void update(Observable carro, Object arg)
  {
    if (((Carro) carro).getEstado() == CarroEstadoEmManutencao.getInstance())
    {
      this.ordensAbertas++;
    }
  }
}
