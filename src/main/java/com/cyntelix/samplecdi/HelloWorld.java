/*
 * This file is part of SampleCdi.
 *
 *     SampleCdi is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     SampleCdi is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with SampleCdi.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.cyntelix.samplecdi;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public
@Model
class HelloWorld {
    private final String text = "Hello, World!";

    @Inject
    @SampleCdi
    EntityManager entityManager;

    private String letters;

    private String numbers;

    private String email;

    public HelloWorld() {}

    @PostConstruct
    public void initialize() {
        System.out.println(this.getClass().getSimpleName() + " was constructed");
    }

    public String getText() {
        return "There are " + entityManager.getMetamodel().getEntities().size() + " entities here.";
    }

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[A-Za-z]*", message = "must contain only letters")
    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    @NotNull
    @NotEmpty
    @Digits(fraction = 0, integer = 2)
    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    @NotNull
    @NotEmpty
    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
