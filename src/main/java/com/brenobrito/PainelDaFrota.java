package com.brenobrito;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class PainelDaFrota implements Observer
{

  private final List<String> historico = new ArrayList<>();

  public List<String> getHistorico()
  {
    return List.copyOf(this.historico);
  }

  public void acompanhar(Carro carro)
  {
    carro.addObserver(this);
  }

  @Override
  public void update(Observable carro, Object arg)
  {
    this.historico.add(((Carro) carro).getEstado().getNome());
  }
}
