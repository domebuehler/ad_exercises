package ch.hslu.ad.sw11;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class DeterministicFiniteAutomatonTest {

    @Test
    void testIsWordLanguage() {
        assertAll(
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguage("0")).isTrue(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguage("010")).isTrue(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguage("01110")).isTrue(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguage("0111010")).isTrue(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguage("0101110")).isTrue(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguage("0101010")).isTrue(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguage("00")).isFalse(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguage("1")).isFalse(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguage("0101")).isFalse(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguage("0110")).isFalse(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguage("010010")).isFalse(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguage("01101110")).isFalse(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguage(null)).isFalse()
        );
    }

    @Test
    void testIsWordLanguageRegex() {
        assertAll(
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguageRegex("0")).isTrue(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguageRegex("010")).isTrue(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguageRegex("01110")).isTrue(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguageRegex("0111010")).isTrue(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguageRegex("0101110")).isTrue(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguageRegex("0101010")).isTrue(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguageRegex("00")).isFalse(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguageRegex("1")).isFalse(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguageRegex("0101")).isFalse(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguageRegex("0110")).isFalse(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguageRegex("010010")).isFalse(),
                () -> assertThat(DeterministicFiniteAutomaton.isWordLanguageRegex(null)).isFalse()
        );
    }
}