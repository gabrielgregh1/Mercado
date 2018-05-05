
package model.bean;


public class Produto {
    private String descricao;
    private double Preco;
    private int codigo;

    public Produto() {}

    public Produto(String descricao, double Preco, int codigo) {
        this.descricao = descricao;
        this.Preco = Preco;
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double Preco) {
        this.Preco = Preco;
    }
    
    
}
