# ⚡ Gnixia — AI on Your Wrist

> **Your cognitive edge, powered by Gemini, right on your wrist.**

Gnixia is a premium **Wear OS** application that traz assistência cognitiva com IA diretamente para o seu smartwatch. Com uma interface projetada especificamente para telas circulares OLED, a experiência é fluida, elegante e responsiva — como um instrumento de laboratório de alta precisão no seu pulso.

---

## 📸 Visão Geral

```
⚡ Gnix AI
├── Tela de Login com "Quantum Link"
├── Componentes UI reutilizáveis (Design System próprio)
├── Navegação com SwipeDismissable (padrão Wear OS)
├── Integração com Gemini AI (em desenvolvimento)
└── App standalone — funciona sem smartphone pareado
```

---

## 🚀 Tecnologias

| Categoria | Tecnologia |
|---|---|
| 📱 Plataforma | Wear OS (min SDK 30) |
| 🎨 UI Framework | Jetpack Compose + Wear Compose Material3 |
| 🧭 Navegação | `SwipeDismissableNavHost` |
| 💡 Linguagem | Kotlin 2.2.10 |
| 🤖 IA | Google Gemini AI *(em integração)* |
| 🔧 Build | Gradle AGP 9.1.0 + Version Catalogs |
| 📦 Serialização | Kotlinx Serialization 1.8.1 |
| 🎯 Target SDK | 36 |

---

## 🏗️ Arquitetura

```
com.davi.dev.gnixia
└── presentation/
    ├── 🏠 MainActivity.kt          # Entry point
    ├── 🧭 navigation/
    │   └── WearAppNavigator.kt     # Rotas + SwipeDismissableNavHost
    ├── 📺 screens/
    │   └── LoginScreen.kt          # Tela de boas-vindas e login
    ├── 🧩 components/
    │   ├── GnixiaButton.kt         # Botões Primary e Ghost
    │   ├── GnixiaInputField.kt     # Campo de entrada minimalista
    │   ├── GnixiaChatBubble.kt     # Balões de chat (usuário + IA)
    │   └── GnixiaAiPulse.kt        # Indicador animado "IA pensando"
    └── 🎨 theme/
        ├── Theme.kt                # GnixiaTheme
        ├── Color.kt                # Paleta OLED otimizada
        ├── Type.kt                 # Tipografia Inter
        ├── Spacing.kt              # Escala de espaçamento
        └── Shape.kt                # Formas assimétricas
```

**Padrão:** MVVM-lite com Clean Presentation Layer

---

## 🎨 Design System — "The Ethereal Pulse"

A interface foi construída sobre um design system próprio com filosofia de **instrumento de laboratório premium**. O objetivo é uma experiência visual que "respira" — alta performance em telas redondas OLED sem bordas ou sombras tradicionais.

### 🎨 Paleta de Cores

```
🔵 Primary          #ADC6FF  — Azul elétrico suave
⚡ Primary Container #4B8EFF  — Azul de alta energia
🟦 Secondary        #46EAED  — Teal accent
⬛ Background       #000000  — Preto OLED puro
🌑 Surface          #1E1E1E  — Superfície base
📄 On Surface       #E2E2E2  — Texto (nunca branco puro)
🔴 Error            #FF8A80  — Estado de erro
```

> **Regra OLED:** Nunca use `#FFFFFF` para texto. Use `#E2E2E2` para evitar bloom na tela.

### ✍️ Tipografia (Inter)

| Token | Tamanho | Uso |
|---|---|---|
| `Display Large` | 48sp Bold | Destaque máximo |
| `Title Large` | 22sp SemiBold | Títulos de tela |
| `Body Medium` | 14sp Normal | Respostas da IA |
| `Label Small` | 11sp Medium | Timestamps, metadata (ALL CAPS) |

### 📐 Espaçamento

```
Spacing-4 → 14dp  ← Margem horizontal padrão (evita clipagem na borda circular)
Spacing-3 → 10dp  ← Padding interno de balões
Spacing-1 →  3dp  ← Gap entre mensagens do mesmo remetente
```

---

## 🧩 Componentes UI

### ⚡ GnixiaAiPulse *(Componente Signature)*
Elemento circular animado que indica que a IA está processando. Usa gradiente radial Secondary → Primary com animação de escala `1.0 ↔ 1.05` em loop suave de 1200ms.

### 💬 Chat Bubbles
- **UserChatBubble** — Fundo `Surface Container Low`, cantos assimétricos (canto inferior direito: 8dp)
- **AiChatBubble** — Fundo `Surface Container High`, canto superior esquerdo: 8dp

### 🔘 Botões
- **GnixiaPrimaryButton** — Pílula com gradiente vertical `PrimaryContainer → Primary`
- **GnixiaGhostButton** — Sem fundo, texto em Primary color

### 📝 GnixiaInputField
Campo minimalista em formato pílula, sem borda visível, fundo `Surface Container Highest (#353535)`.

---

## 📺 Telas

### 🔐 Login Screen
- Branding **"Quantum Link"**
- Headline **"Gnix AI"** em Display Large
- Ícone de raio em círculo azul (80dp)
- Tagline da proposta de valor
- Botão **"Entrar com Google"**
- Indicador de versão: `V2.4.0 HIGH-VOLTAGE`
- Indicadores de página (dots pagination)

---

## 🧭 Navegação

```kotlin
sealed class Screen(val route: String) {
    object Login : Screen("login_screen")
    // 🚧 Chat, Voice, Settings em desenvolvimento...
}
```

Utiliza `SwipeDismissableNavHost` — o padrão nativo Wear OS que permite dispensar telas com gesto de arrastar, como os apps nativos do relógio.

---

## ⚙️ Configuração do Projeto

### Pré-requisitos

- Android Studio Narwhal (ou superior)
- JDK 11+
- Wear OS emulator ou dispositivo físico (API 30+)

### Clonar e executar

```bash
git clone https://github.com/davigomesflorencio/gnixia.git
cd gnixia
./gradlew assembleDebug
```

### Estrutura de Build

```
compileSdk  36.1
targetSdk   36
minSdk      30
versionCode 1
versionName "1.0"
```

---

## 🗺️ Roadmap

- [x] ⚡ Design system "The Ethereal Pulse"
- [x] 🎨 Componentes UI base (Button, Input, ChatBubble, AiPulse)
- [x] 🔐 Tela de Login
- [x] 🧭 Navegação Wear OS
- [ ] 💬 Tela de Chat com IA
- [ ] 🎤 Entrada por voz
- [ ] 🤖 Integração Gemini AI
- [ ] ⚙️ Tela de Configurações
- [ ] 🔗 Comunicação com app Android (DataLayer API)
- [ ] 🚀 Publicação na Play Store

---

## 📁 Principais Regras de Design

| Regra | Descrição |
|---|---|
| 🚫 **No-Line Rule** | Bordas de 1px são proibidas. Use variação tonal para separar seções. |
| 🌑 **OLED First** | Fundo preto puro `#000000`. Evita consumo de bateria desnecessário. |
| ✨ **Ambient Glow** | Em vez de sombras: brilho externo de 4px com `Primary @ 10%` de opacidade. |
| 🔲 **Máx 3 elementos** | No máximo 3 elementos interativos por tela. Ações secundárias em overflow. |
| 📐 **Respeite a curva** | Use `Spacing-4 (14dp)` como margem horizontal padrão para evitar clipagem circular. |

---

## 👨‍💻 Desenvolvedor

**Davi Gomes Florêncio**
📦 `com.davi.dev.gnixia`

---

## 📄 Licença

Este projeto é privado e de propriedade do desenvolvedor.

---

<div align="center">
  <strong>⚡ Gnixia — Inteligência no seu pulso.</strong>
</div>
