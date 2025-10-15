# Padrões de Projeto
Avaliação prática 1° bimestre


Pacotes:
- `q1` – Cálculo de tarifas (Herança e Polimorfismo)
- `q2` – Processadores de pagamento (Factory Method)
- `q3` – Notificações por tópicos (Observer)
- `q4` – Relatórios extensíveis (Decorator)
- `q5` – Modelos clonáveis (Prototype)
- `RPG` – Sistema de combate RPG (Strategy)

## Justificativas dos Padrões

- Questão 1 — Herança/Polimorfismo: uma classe base define a operação de cálculo e cada modalidade (terrestre, aéreo, marítimo) especializa o comportamento via sobrescrita, permitindo tratar genericamente por tipo base sem condicionais extensas.
- Questão 2 — Factory Method: instancia dinamicamente o processador de pagamento correto a partir de uma configuração, desacoplando o cliente dos detalhes de criação e favorecendo OCP.
- Questão 3 — Observer: leitores (observers) se inscrevem em tópicos (subjects). A publicação notifica automaticamente inscritos sem acoplamento forte e sem controle manual de listas pelo cliente.
- Questão 4 — Decorator: adiciona funcionalidades opcionais (estatísticas, gráficos, exportação) ao relatório básico via composição e não herança rígida, permitindo extensão progressiva.
- Questão 5 — Prototype: permite clonar um modelo de documento para personalização rápida (cores, fontes, logotipo) sem reconstruir toda a estrutura.
- RPG — Strategy: implementa um sistema de combate RPG onde diferentes armas encapsulam algoritmos de ataque específicos, permitindo que personagens troquem estratégias de combate dinamicamente sem modificar sua estrutura base.
