package br.com.projeto.deliver.controller;

import br.com.projeto.deliver.controller.dto.ContaRequisicao;
import br.com.projeto.deliver.controller.dto.ContaResponse;
import br.com.projeto.deliver.model.Conta;
import br.com.projeto.deliver.repository.ContaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/conta")

public class ContaController {

    private final ContaRepository contaRepository;

    public ContaController(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    //  private final PessoaCustomRepository pessoaCustomRepository;
//
//    public ContasController(ContasRepository contasRepository,
//                            PessoaCustomRepository pessoaCustomRepository) {
//        this.contasRepository = contasRepository;
//        this.pessoaCustomRepository = pessoaCustomRepository;
//    }

    @GetMapping("/")
    public List<ContaResponse> findAll() {
        var contas = contaRepository.findAll();
        return contas
                .stream()
                .map(ContaResponse::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ContaResponse findById(@PathVariable("id") Long idConta) {
        var contas = contaRepository.getOne(idConta);
        return ContaResponse.converter(contas);
    }

    @PostMapping("/")
    public void savePerson(@RequestBody ContaRequisicao conta) {

        var c = new Conta();


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataInicial = null;
        Date dataFinal = null;

        try {

            dataInicial = sdf.parse(conta.getDataVencimento());

            dataFinal = sdf.parse(conta.getDataPagamento());
        } catch (java.text.ParseException e) { return; }

        long diferencaMS = dataFinal.getTime() - dataInicial.getTime();
        long diferencaSegundos = diferencaMS / 1000;
        long diferencaMinutos = diferencaSegundos / 60;
        long diferencaHoras = diferencaMinutos / 60;
        long diferencaDias = diferencaHoras / 24;

        System.out.println(diferencaMS);
        System.out.println(diferencaSegundos);
        System.out.println(diferencaMinutos);
        System.out.println(diferencaHoras);
        System.out.println(diferencaDias);



        c.setNomeConta(conta.getNomeConta());
        c.setValorOriginal(conta.getValorOriginal());
        c.setValorCorrigido(conta.getValorCorrigido());
        c.setDataVencimento(conta.getDataVencimento());
        c.setDataPagamento(conta.getDataPagamento());
        c.setDiasAtraso(diferencaDias);

        contaRepository.save(c);
    }

    @PutMapping("/{id}")
    public void updatePerson(@PathVariable("id") Long id, @RequestBody ContaRequisicao conta) throws Exception {
        var c = contaRepository.findById(id);

        if (c.isPresent()) {

            var contaSave = c.get();

            contaSave.setNomeConta(conta.getNomeConta());
            contaSave.setValorOriginal(conta.getValorOriginal());
            contaSave.setValorCorrigido(conta.getValorCorrigido());
            contaSave.setDataVencimento(conta.getDataVencimento());
            contaSave.setDataPagamento(conta.getDataPagamento());
            contaSave.setDiasAtraso(conta.getDiasAtraso());
            contaRepository.save(contaSave);
        } else {
            throw new Exception("Conta Não encontrada");
        }
    }

}
