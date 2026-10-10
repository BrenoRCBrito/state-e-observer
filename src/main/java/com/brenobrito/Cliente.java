package com.brenobrito;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer
{

  private final String nome;

  private String ultimaNotificacao;

  public Cliente(String nome)
  {
    this.nome = nome;
  }

  public String getUltimaNotificacao()
  {
    return this.ultimaNotificacao;
  }

  public void acompanhar(Carro carro)
  {
    carro.addObserver(this);
  }

  @Override
  public void update(Observable carro, Object arg)
  {
    Carro acompanhado = (Carro) carro;
    this.ultimaNotificacao = this.nome + ", o carro " + acompanhado.getPlaca()
        + " esta " + acompanhado.getEstado().getNome();
  }
}
