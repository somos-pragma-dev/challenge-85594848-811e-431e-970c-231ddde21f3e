# Fundamentos de los principios SOLID en el desarrollo de software

Los principios SOLID son un conjunto de conceptos que guían a los desarrolladores en la creación de software más mantenible y escalable. En este desafío, exploraremos cada uno de estos principios en el contexto de un sistema de gestión de cuentas bancarias. Los actores clave incluyen el 'gestor de cuentas', el'sistema de autenticación' y el'motor de notificaciones'. El sistema debe manejar un volumen de 10 000 transacciones por hora con una latencia máxima de 2 segundos por operación. El objetivo es entender y aplicar estos principios para mejorar la calidad del código y la estructura del sistema.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | SOLID principles |
| **Nivel** | junior-l1 |
| **Tipo** | theoretical |
| **Tiempo estimado** | 2 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Introducción a los principios SOLID

**Objetivo:** Comprender los cinco principios SOLID y su importancia en el desarrollo de software.

**Tiempo estimado:** 30 minutos

**Instrucciones:**

- Investiga y resume cada uno de los principios SOLID: Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Dependency Inversion.
- Identifica ejemplos de código que violen cada principio y propone soluciones para corregirlas.

**Entregable:** Resumen de los principios SOLID con ejemplos y soluciones.

<details>
<summary>Pistas de conocimiento</summary>

- Reflexiona sobre cómo cada principio puede mejorar la mantenibilidad y escalabilidad del código.
- Considera escenarios donde la violación de un principio podría llevar a problemas en el sistema.

</details>

### Fase 2: Aplicación de los principios SOLID en un sistema de gestión de cuentas

**Objetivo:** Aplicar los principios SOLID en un sistema de gestión de cuentas bancarias.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Diseña un sistema de gestión de cuentas que siga los principios SOLID. Considera las interacciones entre el 'gestor de cuentas', el'sistema de autenticación' y el'motor de notificaciones'.
- Identifica posibles violaciones de los principios SOLID en tu diseño y propone soluciones para corregirlas.

**Entregable:** Diagrama de clases que muestra la aplicación de los principios SOLID en el sistema de gestión de cuentas.

<details>
<summary>Pistas de conocimiento</summary>

- Piensa en cómo cada principio SOLID puede ser aplicado para mejorar la estructura y mantenibilidad del sistema.
- Reflexiona sobre las posibles consecuencias de no aplicar correctamente los principios SOLID.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son los principios SOLID y por qué son importantes en el desarrollo de software?
- **paraQueSirve**: ¿Cómo pueden los principios SOLID mejorar la calidad del código y la estructura del sistema?
- **comoSeUsa**: ¿Cómo aplicarías los principios SOLID en un sistema de gestión de cuentas bancarias?
- **erroresComunes**: ¿Cuáles son los errores comunes al aplicar los principios SOLID y cómo pueden ser corregidos?
- **queDecisionesImplica**: ¿Qué decisiones de diseño implica la aplicación de los principios SOLID en un sistema?

## Criterios de Evaluacion

- Comprensión clara de los principios SOLID.
- Aplicación correcta de los principios SOLID en el diseño del sistema.
- Identificación y corrección de posibles violaciones de los principios SOLID.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
el comando de build o arranque canonico del stack elegido
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
