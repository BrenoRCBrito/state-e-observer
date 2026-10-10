package com.brenobrito;

public abstract class CarroEstado
{

  private final String msgPadrao = "Estado não permitido";

  public abstract String getNome();

  public void disponivel(Carro carro)
  {
    throw new RuntimeException(msgPadrao);
  }

  public void reservado(Carro carro)
  {
    throw new RuntimeException(msgPadrao);
  }

  public void alugado(Carro carro)
  {
    throw new RuntimeException(msgPadrao);
  }

  public void emManutencao(Carro carro)
  {
    throw new RuntimeException(msgPadrao);
  }

  public void inativo(Carro carro)
  {
    throw new RuntimeException(msgPadrao);
  }
}
