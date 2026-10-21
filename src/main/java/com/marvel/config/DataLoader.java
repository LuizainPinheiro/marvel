package com.marvel.config;

import com.marvel.model.Equipe;
import com.marvel.model.Heroi;
import com.marvel.repository.EquipeRepository;
import com.marvel.repository.HeroiRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final EquipeRepository equipeRepository;
    private final HeroiRepository heroiRepository;

    public DataLoader(EquipeRepository equipeRepository, HeroiRepository heroiRepository) {
        this.equipeRepository = equipeRepository;
        this.heroiRepository = heroiRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // 1. LIMPEZA
        heroiRepository.deleteAllInBatch();
        equipeRepository.deleteAllInBatch();

        // ==========================================
        // 2. VINGADORES
        // ==========================================
        Equipe vingadores = new Equipe();
        vingadores.setNome("Vingadores");
        vingadores.setOrigem("1963");
        vingadores.setImagemUrl("https://i.imgur.com/v8S75s9.png");
        equipeRepository.save(vingadores);

        Heroi homemDeFerro = new Heroi();
        homemDeFerro.setNome("Homem de Ferro");
        homemDeFerro.setNomeReal("Tony Stark");
        homemDeFerro.setOcupacao("Empresário, Inventor, Filantropo");
        homemDeFerro.setPoderes("Inteligência genial, Armadura de alta tecnologia com voo, rajadas de repulsores e proteção avançada");
        homemDeFerro.setInimigos("Monk Stane (Monge de Ferro), Mandarim, Whiplash, Ultron");
        homemDeFerro.setFilmes("Homem de Ferro, Homem de Ferro 2, Homem de Ferro 3, Os Vingadores, Vingadores: Era de Ultron, Capitão América: Guerra Civil, Vingadores: Guerra Infinita, Vingadores: Ultimato");
        homemDeFerro.setImagemUrl("https://www.stickpng.com/pt-br/cat/quadrinhos-e-fantasia/homem-de-ferro?page=1");
        homemDeFerro.setEquipe(vingadores);

        Heroi capitaoAmerica = new Heroi();
        capitaoAmerica.setNome("Capitão América");
        capitaoAmerica.setNomeReal("Steve Rogers");
        capitaoAmerica.setOcupacao("Soldado");
        capitaoAmerica.setPoderes("Força, agilidade e resistência sobre-humanas, Mestre em artes marciais, Escudo de Vibranium indestrutível");
        capitaoAmerica.setInimigos("Caveira Vermelha, Soldado Invernal (anteriormente), Ossos Cruzados, Barão Zemo");
        capitaoAmerica.setFilmes("Capitão América: O Primeiro Vingador, Os Vingadores, Capitão América: O Soldado Invernal, Vingadores: Era de Ultron, Capitão América: Guerra Civil, Vingadores: Guerra Infinita, Vingadores: Ultimato");
        capitaoAmerica.setImagemUrl("https://i.pinimg.com/736x/98/97/f6/9897f6768f2fb3cb467742a214aa0270.jpg");
        capitaoAmerica.setEquipe(vingadores);

        Heroi thor = new Heroi();
        thor.setNome("Thor");
        thor.setNomeReal("Thor Odinson");
        thor.setOcupacao("Rei de Asgard / Protetor dos Nove Reinos");
        thor.setPoderes("Fisiologia de Deus do Trovão, Superforça e invulnerabilidade, Manipulação de raios e trovões, Voo com Mjolnir/Stormbreaker");
        thor.setInimigos("Loki (anteriormente), Hela, Gorr o Carniceiro dos Deuses, Malekith");
        thor.setFilmes("Thor, Os Vingadores, Thor: O Mundo Sombrio, Vingadores: Era de Ultron, Thor: Ragnarok, Vingadores: Guerra Infinita, Vingadores: Ultimato, Thor: Amor e Trovão");
        thor.setImagemUrl("https://i.pinimg.com/736x/c9/3c/1e/c93c1efdb8967dc6efe173a4b45c1617.jpg");
        thor.setEquipe(vingadores);

        Heroi hulk = new Heroi();
        hulk.setNome("Hulk");
        hulk.setNomeReal("Bruce Banner");
        hulk.setOcupacao("Cientista / Físico Nuclear");
        hulk.setPoderes("Força física quase ilimitada, Resistência extrema, Fator de cura acelerado, Saltos gigantescos");
        hulk.setInimigos("Abominação, Líder, General Ross");
        hulk.setFilmes("O Incrível Hulk, Os Vingadores, Vingadores: Era de Ultron, Thor: Ragnarok, Vingadores: Guerra Infinita, Vingadores: Ultimato");
        hulk.setImagemUrl("https://pt.pinterest.com/ideas/fotos-do-hulk-jogador/907457130198/");
        hulk.setEquipe(vingadores);

        Heroi viuvaNegra = new Heroi();
        viuvaNegra.setNome("Viúva Negra");
        viuvaNegra.setNomeReal("Natasha Romanoff");
        viuvaNegra.setOcupacao("Espiã, Agente da S.H.I.E.L.D.");
        viuvaNegra.setPoderes("Mestre em artes marciais e espionagem, Pico de condição humana, Especialista em armas e táticas");
        viuvaNegra.setInimigos("Treinador (Taskmaster), Dreykov");
        viuvaNegra.setFilmes("Homem de Ferro 2, Os Vingadores, Capitão América: O Soldado Invernal, Vingadores: Era de Ultron, Capitão América: Guerra Civil, Vingadores: Guerra Infinita, Vingadores: Ultimato, Viúva Negra");
        viuvaNegra.setImagemUrl("https://static.wikia.nocookie.net/universocinematograficomarvel/images/3/38/Nat_BW.jpg/revision/latest?cb=20211229224720&path-prefix=pt");
        viuvaNegra.setEquipe(vingadores);

        heroiRepository.saveAll(Arrays.asList(homemDeFerro, capitaoAmerica, thor, hulk, viuvaNegra));

        // ==========================================
        // 3. X-MEN
        // ==========================================
        Equipe xmen = new Equipe();
        xmen.setNome("X-Men");
        xmen.setOrigem("1963");
        xmen.setImagemUrl("https://i.imgur.com/XmenLogo.png");
        equipeRepository.save(xmen);

        Heroi wolverine = new Heroi();
        wolverine.setNome("Wolverine");
        wolverine.setNomeReal("Logan / James Howlett");
        wolverine.setOcupacao("Soldado, Instrutor");
        wolverine.setPoderes("Fator de cura mutante, Esqueleto e gavras revestidos de Adamantium, Sentidos aguçados");
        wolverine.setInimigos("Dentes-de-Sabre, Lady Letal, William Stryker, X-24");
        wolverine.setFilmes("X-Men, X-Men 2, X-Men: O Confronto Final, X-Men Origens: Wolverine, X-Men: Dias de um Futuro Esquecido, Wolverine: Imortal, Logan, Deadpool & Wolverine");
        wolverine.setImagemUrl("https://static.wikia.nocookie.net/universocinematograficomarvel/images/5/5d/Wolverine.png/revision/latest?cb=20240722043940&path-prefix=pt");
        wolverine.setEquipe(xmen);

        Heroi professorX = new Heroi();
        professorX.setNome("Professor X");
        professorX.setNomeReal("Charles Xavier");
        professorX.setOcupacao("Líder dos X-Men, Professor, Geneticista");
        professorX.setPoderes("Telepatia de nível Ômega, Controle mental, Projeção astral, Manipulação de memórias");
        professorX.setInimigos("Magneto (rival/aliado), Apocalipse, Cassandra Nova");
        professorX.setFilmes("X-Men, X-Men 2, X-Men: O Confronto Final, X-Men: Primeira Classe, X-Men: Dias de um Futuro Esquecido, X-Men: Apocalipse, X-Men: Fênix Negra, Logan");
        professorX.setImagemUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPuQEV1x7j9tZpcG63fQkvZuKzbUxJYm8uO-NtZhwfRg&s=10");
        professorX.setEquipe(xmen);

        Heroi tempestade = new Heroi();
        tempestade.setNome("Tempestade");
        tempestade.setNomeReal("Ororo Munroe");
        tempestade.setOcupacao("Professora, Líder dos X-Men");
        tempestade.setPoderes("Manipulação das forças meteorológicas (clima), Voo, Geração de raios e vendavais");
        tempestade.setInimigos("Apocalipse, Magneto");
        tempestade.setFilmes("X-Men, X-Men 2, X-Men: O Confronto Final, X-Men: Dias de um Futuro Esquecido, X-Men: Apocalipse, X-Men: Fênix Negra");
        tempestade.setImagemUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQt3eXD7kIf9og9wH0JQy1UsBPc6VqplMb0WCsN4FKm4ZKgFfGxtJOkdnvu&s=10");
        tempestade.setEquipe(xmen);

        Heroi ciclope = new Heroi();
        ciclope.setNome("Ciclope");
        ciclope.setNomeReal("Scott Summers");
        ciclope.setOcupacao("Líder de Campo dos X-Men, Professor");
        ciclope.setPoderes("Rajadas ópticas de energia concussiva");
        ciclope.setInimigos("Sr. Sinistro, Magneto, Sentinelas");
        ciclope.setFilmes("X-Men, X-Men 2, X-Men: O Confronto Final, X-Men: Primeira Classe, X-Men: Apocalipse, X-Men: Fênix Negra");
        ciclope.setImagemUrl("https://i.redd.it/fhc4gd1aa1pg1.png");
        ciclope.setEquipe(xmen);

        Heroi jeanGrey = new Heroi();
        jeanGrey.setNome("Jean Grey");
        jeanGrey.setNomeReal("Jean Grey");
        jeanGrey.setOcupacao("Médica, Professora");
        jeanGrey.setPoderes("Telepatia, Telecinese, Hospedeira da Força Fênix");
        jeanGrey.setInimigos("Magneto, Mestre Mental, Sentinelas");
        jeanGrey.setFilmes("X-Men, X-Men 2, X-Men: O Confronto Final, X-Men: Dias de um Futuro Esquecido, X-Men: Apocalipse, X-Men: Fênix Negra");
        jeanGrey.setImagemUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9TFSSYoc1RwLr1ve8xyvSgVxF5VACOipUeuLsv3mVRmWwwLRWacCgF3U&s=10");
        jeanGrey.setEquipe(xmen);

        heroiRepository.saveAll(Arrays.asList(wolverine, professorX, tempestade, ciclope, jeanGrey));

        // ==========================================
        // 4. GUARDIÕES DA GALÁXIA
        // ==========================================
        Equipe guardioes = new Equipe();
        guardioes.setNome("Guardiões da Galáxia");
        guardioes.setOrigem("2008");
        guardioes.setImagemUrl("https://i.imgur.com/GotgLogo.png");
        equipeRepository.save(guardioes);

        Heroi starlord = new Heroi();
        starlord.setNome("Senhor das Estrelas");
        starlord.setNomeReal("Peter Quill");
        starlord.setOcupacao("Mercenário, Saqueador, Líder do Grupo");
        starlord.setPoderes("Mestre em combate e táticas, Uso de pistolas quânticas e botas a jato, Herança híbrida celestiana (anteriormente)");
        starlord.setInimigos("Ego, o Planeta Vivo, Ronan, o Acusador, Alto Evolucionário");
        starlord.setFilmes("Guardiões da Galáxia, Guardiões da Galáxia Vol. 2, Vingadores: Guerra Infinita, Vingadores: Ultimato, Guardiões da Galáxia Vol. 3");
        starlord.setImagemUrl("https://cinepop.com.br/wp-content/uploads/2026/01/chris-pratt-1068x580.jpg");
        starlord.setEquipe(guardioes);

        Heroi gamora = new Heroi();
        gamora.setNome("Gamora");
        gamora.setNomeReal("Gamora Zen Whoberi Ben Titan");
        gamora.setOcupacao("Assassina, Mercenária");
        gamora.setPoderes("Força, agilidade e reflexos aprimorados ciberneticamente, Mestre em combate corpo a corpo e espadas");
        gamora.setInimigos("Thanos, Ronan, o Acusador, Nebulosa (anteriormente)");
        gamora.setFilmes("Guardiões da Galáxia, Guardiões da Galáxia Vol. 2, Vingadores: Guerra Infinita, Vingadores: Ultimato, Guardiões da Galáxia Vol. 3");
        gamora.setImagemUrl("https://editorial.rottentomatoes.com/wp-content/uploads/2017/04/gamora.jpg");
        gamora.setEquipe(guardioes);

        Heroi drax = new Heroi();
        drax.setNome("Drax, o Destruidor");
        drax.setNomeReal("Drax");
        drax.setOcupacao("Guerreiro");
        drax.setPoderes("Força sobre-humana, Resistência física elevada, Especialista no uso de adagas");
        drax.setInimigos("Ronan, o Acusador, Thanos");
        drax.setFilmes("Guardiões da Galáxia, Guardiões da Galáxia Vol. 2, Vingadores: Guerra Infinita, Vingadores: Ultimato, Guardiões da Galáxia Vol. 3");
        drax.setImagemUrl("https://editorial.rottentomatoes.com/wp-content/uploads/2017/04/drax.jpg");
        drax.setEquipe(guardioes);

        Heroi rocket = new Heroi();
        rocket.setNome("Rocket Raccoon");
        rocket.setNomeReal("Rocket (Sujeito 89P13)");
        rocket.setOcupacao("Piloto, Engenheiro de Armas, Mercenário");
        rocket.setPoderes("Inteligência genial em engenharia e tecnologia, Mestre em pontaria e táticas de combate");
        rocket.setInimigos("Alto Evolucionário, Ronan, o Acusador");
        rocket.setFilmes("Guardiões da Galáxia, Guardiões da Galáxia Vol. 2, Vingadores: Guerra Infinita, Vingadores: Ultimato, Guardiões da Galáxia Vol. 3");
        rocket.setImagemUrl("https://static.wikia.nocookie.net/marvelcinematicuniverse/images/3/30/Rocket_Vol._3.jpg/revision/latest?cb=20231114031203");
        rocket.setEquipe(guardioes);

        Heroi groot = new Heroi();
        groot.setNome("Groot");
        groot.setNomeReal("Groot");
        groot.setOcupacao("Guarda-costas, Guerreiro");
        groot.setPoderes("Manipulação do próprio corpo de madeira (crescimento e regeneração), Superforça, Elasticidade");
        groot.setInimigos("Ronan, o Acusador, Alto Evolucionário");
        groot.setFilmes("Guardiões da Galáxia, Guardiões da Galáxia Vol. 2, Vingadores: Guerra Infinita, Vingadores: Ultimato, Guardiões da Galáxia Vol. 3");
        groot.setImagemUrl("https://p2.trrsf.com/image/fget/cf/1200/1600/middle/images.terra.com/2023/08/06/383152932-i-am-groot.jpg");
        groot.setEquipe(guardioes);

        heroiRepository.saveAll(Arrays.asList(starlord, gamora, drax, rocket, groot));

        // ==========================================
        // 5. QUARTETO FANTÁSTICO
        // ==========================================
        Equipe quarteto = new Equipe();
        quarteto.setNome("Quarteto Fantástico");
        quarteto.setOrigem("1961");
        quarteto.setImagemUrl("https://i.imgur.com/FantasticFour.png");
        equipeRepository.save(quarteto);

        Heroi reed = new Heroi();
        reed.setNome("Senhor Fantástico");
        reed.setNomeReal("Reed Richards");
        reed.setOcupacao("Cientista, Inventor, Líder do Grupo");
        reed.setPoderes("Super-elasticidade corporal, Inteligência genial (nível intelecto supremo)");
        reed.setInimigos("Doutor Destino, Galactus, Homem-Toupeira, Aniquilador");
        reed.setFilmes("Quarteto Fantástico (2005), Quarteto Fantástico e o Surfista Prateado, Quarteto Fantástico (2015)");
        reed.setImagemUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGXobTZPWGO9D4rJPT78TK7YOFU7rZx0xJMvu52siQNW0m3CdXfBiAo3Wx&s=10");
        reed.setEquipe(quarteto);

        Heroi susan = new Heroi();
        susan.setNome("Mulher Invisível");
        susan.setNomeReal("Susan Storm Richards");
        susan.setOcupacao("Cientista, Professora");
        susan.setPoderes("Invisibilidade, Geração e manipulação de campos de força invisíveis");
        susan.setInimigos("Doutor Destino, Galactus, Super-Skrull");
        susan.setFilmes("Quarteto Fantástico (2005), Quarteto Fantástico e o Surfista Prateado, Quarteto Fantástico (2015)");
        susan.setImagemUrl("https://static.wikia.nocookie.net/universocinematograficomarvel/images/6/69/Invisible_Woman_Infobox.png/revision/latest?cb=20250726015429&path-prefix=pt");
        susan.setEquipe(quarteto);

        Heroi johnny = new Heroi();
        johnny.setNome("Tocha Humana");
        johnny.setNomeReal("Johnny Storm");
        johnny.setOcupacao("Piloto, Aventureiro");
        johnny.setPoderes("Pirocinese (geração e controle de fogo), Voo, Absorção de calor");
        johnny.setInimigos("Doutor Destino, Galactus, Homem Impossível");
        johnny.setFilmes("Quarteto Fantástico (2005), Quarteto Fantástico e o Surfista Prateado, Quarteto Fantástico (2015)");
        johnny.setImagemUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSdA6riONU_MMxYkuVYDYkwzPn8UCLu4llAEcIdFsvbs89bmIsrtwMZmwc&s=10");
        johnny.setEquipe(quarteto);

        Heroi coisa = new Heroi();
        coisa.setNome("O Coisa");
        coisa.setNomeReal("Ben Grimm");
        coisa.setOcupacao("Piloto de Testes, Astronauta");
        coisa.setPoderes("Força e resistência sobre-humanas, Corpo revestido por pele rochosa altamente resistente");
        coisa.setInimigos("Doutor Destino, Galactus, Homem-Toupeira");
        coisa.setFilmes("Quarteto Fantástico (2005), Quarteto Fantástico e o Surfista Prateado, Quarteto Fantástico (2015)");
        coisa.setImagemUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHbrP5dggSOdFntz7ibcboQ7S6g5ggYy25H5af-3OwnQejjosdc2WvumGz&s=10");
        coisa.setEquipe(quarteto);

        heroiRepository.saveAll(Arrays.asList(reed, susan, johnny, coisa));
    }
}