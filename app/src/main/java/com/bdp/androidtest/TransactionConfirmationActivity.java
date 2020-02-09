package com.bdp.androidtest;

import android.app.Service;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class TransactionConfirmationActivity extends AppCompatActivity implements View.OnFocusChangeListener, View.OnKeyListener, TextWatcher {

    EditText etPinFirst;
    EditText etPinSecond;
    EditText etPinThird;
    EditText etPinForth;
    EditText etPinFifth;
    EditText etPinSixth;
    EditText etPinHidden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // PANTALLA 2
        setContentView(R.layout.activity_confirm_transaction);

        init();
        setPinListeners();
    }

    private void init() {
        etPinFirst = findViewById(R.id.etPinFirst);
        etPinSecond = findViewById(R.id.etPinSecond);
        etPinThird = findViewById(R.id.etPinThird);
        etPinForth = findViewById(R.id.etPinForth);
        etPinFifth = findViewById(R.id.etPinFifth);
        etPinSixth = findViewById(R.id.etPinSixth);

        etPinHidden = findViewById(R.id.etPinHidden);
    }

    private void setPinListeners() {
        etPinHidden.addTextChangedListener(this);

        etPinFirst.setOnFocusChangeListener(this);
        etPinSecond.setOnFocusChangeListener(this);
        etPinThird.setOnFocusChangeListener(this);
        etPinForth.setOnFocusChangeListener(this);
        etPinFifth.setOnFocusChangeListener(this);
        etPinSixth.setOnFocusChangeListener(this);

        etPinFirst.setOnKeyListener(this);
        etPinSecond.setOnKeyListener(this);
        etPinThird.setOnKeyListener(this);
        etPinForth.setOnKeyListener(this);
        etPinFifth.setOnKeyListener(this);
        etPinSixth.setOnKeyListener(this);
        etPinHidden.setOnKeyListener(this);
    }

    public static void setFocus(EditText editText) {
        if (editText == null)
            return;

        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
    }

    public void showSoftKeyboard(EditText editText) {
        if (editText == null)
            return;

        InputMethodManager imm = (InputMethodManager) getSystemService(Service.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        if (s.length() == 0) {
            //setFocusedPinBackground(mPinFirstDigitEditText);
            etPinFirst.setText("");
            etPinSecond.setText("");
            etPinThird.setText("");
            etPinForth.setText("");
            etPinFifth.setText("");
            etPinSixth.setText("");
        } else if (s.length() == 1) {
            //setFocusedPinBackground(mPinSecondDigitEditText);
            etPinFirst.setText(s.charAt(0) + "");
            etPinSecond.setText("");
            etPinThird.setText("");
            etPinForth.setText("");
            etPinFifth.setText("");
            etPinSixth.setText("");
        } else if (s.length() == 2) {
            //setFocusedPinBackground(mPinThirdDigitEditText);
            etPinSecond.setText(s.charAt(1) + "");
            etPinThird.setText("");
            etPinForth.setText("");
            etPinFifth.setText("");
            etPinSixth.setText("");
        } else if (s.length() == 3) {
            //setFocusedPinBackground(mPinForthDigitEditText);
            etPinThird.setText(s.charAt(2) + "");
            etPinForth.setText("");
            etPinFifth.setText("");
            etPinSixth.setText("");
        } else if (s.length() == 4) {
            //setFocusedPinBackground(mPinFifthDigitEditText);
            etPinForth.setText(s.charAt(3) + "");
            etPinFifth.setText("");
            etPinSixth.setText("");
        } else if (s.length() == 5) {
            //setDefaultPinBackground(mPinFifthDigitEditText);
            etPinFifth.setText(s.charAt(4) + "");
            etPinSixth.setText("");
        } else if (s.length() == 6) {
            //setDefaultPinBackground(mPinFifthDigitEditText);
            etPinSixth.setText(s.charAt(5) + "");
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        final int id = v.getId();
        switch (id) {
            case R.id.etPinFirst:
                if (hasFocus) {
                    setFocus(etPinHidden);
                    showSoftKeyboard(etPinHidden);
                }
                break;

            case R.id.etPinSecond:
                if (hasFocus) {
                    setFocus(etPinHidden);
                    showSoftKeyboard(etPinHidden);
                }
                break;

            case R.id.etPinThird:
                if (hasFocus) {
                    setFocus(etPinHidden);
                    showSoftKeyboard(etPinHidden);
                }
                break;

            case R.id.etPinForth:
                if (hasFocus) {
                    setFocus(etPinHidden);
                    showSoftKeyboard(etPinHidden);
                }
                break;

            case R.id.etPinFifth:
                if (hasFocus) {
                    setFocus(etPinHidden);
                    showSoftKeyboard(etPinHidden);
                }
                break;

            case R.id.etPinSixth:
                if (hasFocus) {
                    setFocus(etPinHidden);
                    showSoftKeyboard(etPinHidden);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            final int id = v.getId();
            switch (id) {
                case R.id.etPinHidden:
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        if (etPinHidden.getText().length() == 6)
                            etPinSixth.setText("");
                        else if (etPinHidden.getText().length() == 5)
                            etPinFifth.setText("");
                        else if (etPinHidden.getText().length() == 4)
                            etPinForth.setText("");
                        else if (etPinHidden.getText().length() == 3)
                            etPinThird.setText("");
                        else if (etPinHidden.getText().length() == 2)
                            etPinSecond.setText("");
                        else if (etPinHidden.getText().length() == 1)
                            etPinFirst.setText("");

                        if (etPinHidden.length() > 0)
                            etPinHidden.setText(etPinHidden.getText().subSequence(0, etPinHidden.length() - 1));

                        return true;
                    }

                    break;

                default:
                    return false;
            }
        }

        return false;
    }
}
