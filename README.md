## Trabalho Ecommerce 
### Eccomerce Simple : Proposta de um desenvolvimento simples com POO e SOLID 
### Eccomerce Normal : Proposta com uso de Interfaces , SOLID , compra simples e minimalista
### Eccomerce Final  : Proposta qual atinge os requesitos e caso de uso afim . 
#### Detalhes ao respeito : 

## Funcionalidades

- **Clientes**
  - Cadastrar, listar e atualizar os clientes da base.  
  - Não é necessário excluir clientes, pois devem permanecer na base como histórico.  

- **Produtos**
  - Cadastrar, listar e atualizar os produtos da base.  
  - Não é necessário excluir produtos, pois devem permanecer na base como histórico.  

- **Vendas**
  - Criar uma venda para um cliente.  
  - Nessa venda deve ser possível:  
    - Adicionar item (produto) com quantidade e preço.  
    - Remover item (produto).  
    - Alterar quantidade do item (produto).  
    - Realizar o pagamento e a entrega.  

---

## Regras Importantes

- Todo cliente cadastrado precisa ter o documento de identificação.  
- Um pedido sempre deve ter a data em que foi criado.  
- Um pedido sempre deve iniciar com o **status = "Aberto"**.  
- Pedidos com status **"Aberto"** podem:
  - Receber itens (produto).  
  - Alterar quantidade de itens.  
  - Remover itens.  
- Os produtos adicionados ao pedido devem ter um **valor de venda informado**, pois esse valor pode ser diferente do valor padrão do produto.  
- Para que o cliente possa **finalizar o pedido**:
  - O pedido deve ter **ao menos um item**.  
  - O valor do pedido deve ser **maior que zero**.  
  - O status do pagamento deve ser alterado para **"Aguardando pagamento"**.  
  - O cliente deve ser **notificado via e-mail**.  
- O **pagamento** só pode acontecer em pedidos com status **"Aguardando pagamento"**.  
  - Após o pagamento ser concluído com sucesso, o status deve ser alterado para **"Pago"**.  
  - O cliente deve ser **notificado**.  
- Após o pagamento, o pedido pode ser **entregue ao cliente**, e o status deve ser alterado para **"Finalizado"**.  
  - O cliente deve ser **notificado sobre a entrega**.  
