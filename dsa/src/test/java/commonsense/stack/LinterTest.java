package commonsense.stack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LinterTest {
    /*
    	{
			name:    "empty string",
			data:    "",
			want:    true,
			wantErr: nil,
		},
		{
			name:    "simple stack ignored",
			data:    "abscefg",
			want:    true,
			wantErr: nil,
		},
		{
			name:    "(var x = {y: [1,2,3]})",
			data:    "(var x = {y: [1,2,3]})",
			want:    true,
			wantErr: nil,
		},
		{
			name:    "(var x = 2;",
			data:    "(var x = 2;",
			want:    false,
			wantErr: ErrMissingClosingBrace,
		},
		{
			name:    "var x = 2;)",
			data:    "var x = 2;)",
			want:    false,
			wantErr: ErrMissingOpeningBrace,
		},
		{
			name:    "(var x = [1,2,3)];",
			data:    "(var x = [1,2,3)];",
			want:    false,
			wantErr: ErrBraceMismatch,
		},

     */
    @ParameterizedTest
    @CsvSource(value = {
            "abscefg,true",
            "(var x = {y: [1,2,3]}),true",
            "(var x = 2;,false",
            "var x = 2;),false",
            "(var x = [1,2,3)];,false"

    },delimiter = ',')
    public void shouldLintData() {

    }

}