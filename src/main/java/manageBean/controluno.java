package manageBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import modelo.*;
import java.util.*;
import javax.annotation.PostConstruct;
import controlador.Negocio;

@ManagedBean
@ViewScoped
public class controluno implements Serializable {

    Cliente cli;

    List<Cliente> liscli;
    List<Facturas> lisfact;
    List<Detalle> lisdetafact;
    String nombre;

    String numfactura;
    double total;

    public controluno() {
        cli = new Cliente();
    }

    @PostConstruct

    public void init() {
        liscli = new Negocio().LisCli();
    }

    //Cuando se elige una factura por cliente
    public void listado(Cliente c) {
        nombre = c.getNomc();
        lisfact = new Negocio().LisFac(c.getCodc());
        for (Facturas x : lisfact);
    }

    //Cuando se elige detalle por factura
    public void listadodetalle(Facturas f) {
        numfactura = f.getNro();
        lisdetafact = new Negocio().LisDeta(f.getNro());
        total = 0;
        for(Detalle x:lisdetafact) total = x.getPuni()*x.getCan();
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public List<Cliente> getLiscli() {
        return liscli;
    }

    public void setLiscli(List<Cliente> liscli) {
        this.liscli = liscli;
    }

    public List<Facturas> getLisfact() {
        return lisfact;
    }

    public void setLisfact(List<Facturas> lisfact) {
        this.lisfact = lisfact;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Detalle> getLisdetafact() {
        return lisdetafact;
    }

    public void setLisdetafact(List<Detalle> lisdetafact) {
        this.lisdetafact = lisdetafact;
    }

    public String getNumfactura() {
        return numfactura;
    }

    public void setNumfactura(String numfactura) {
        this.numfactura = numfactura;
    }
    
    

}
