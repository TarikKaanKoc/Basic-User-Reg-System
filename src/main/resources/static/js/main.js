$(document).ready(function() {
    handleFormSubmission("#registerForm", "create-user", handleRegisterResponse);
    handleFormSubmission("#loginForm", "validate-login", handleLoginResponse);
});

const handleFormSubmission = (formId, endpoint, responseHandler) => {
    $(formId).submit(function(event) {
        event.preventDefault();
        if (validateForm(formId)) {
            const formData = getFormValues(formId);
            ajaxRequest("POST", `http://localhost:8080/${endpoint}`, formData, responseHandler);
        }
    });
};
const ajaxRequest = (type, url, data, successCallback, errorCallback) => {
    $.ajax({
        type: type,
        contentType: "application/json",
        url: url,
        data: JSON.stringify(data),
        dataType: "json",
        cache: false,
        timeout: 10000,
        success: successCallback,
        error: function(xhr) {
            alert("Hata: " + xhr.status + " Hata kodunu kontrol edin ve yeniden deneyin", "danger");
            if (errorCallback) errorCallback(xhr);
        }
    });
};

const handleRegisterResponse = (data) => {
    if (data.status) {
        alert("Kayıt Başarılı, Giriş sayfasına yönlendiriliyor", "success");
    } else {
        alert("Bu e-posta başka bir kullanıcı tarafından kullanılıyor. Farklı bir e-posta deneyin", "danger");
    }
};

const handleLoginResponse = (data) => {
    if (data.status) {
        alert("Giriş Başarılı", "success");
    } else {
        alert("Hatalı Kimlik Bilgileri", "danger");
    }
};

const validateForm = (formId) => {
    const $form = $(formId);
    if ($form.length) {
        $form.validate({
            errorClass: "error",
            errorElement: "div",
            errorPlacement: function(error, element) {
                error.insertAfter(element);
            },
            highlight: function(element) {
                $(element).closest(".form-floating").addClass("is-invalid");
            },
            unhighlight: function(element) {
                $(element).closest(".form-floating").removeClass("is-invalid");
            },
            messages: {
                name: {
                    required: "Ad zorunludur"
                },
                surname: {
                    required: "Soyad zorunludur"
                },
                email: {
                    required: "E-posta zorunludur"
                },
                password: {
                    required: "Şifrenizi girin"
                },
                password2: {
                    required: "Şifrenizi onaylayın",
                    equalTo: "Şifreler eşleşmiyor"
                },
                tc: {
                    required: "TC Kimlik Numarası zorunludur",
                    digits: "Lütfen sadece rakam girin",
                    minlength: "Lütfen geçerli 11 haneli bir TC Kimlik Numarası girin",
                    maxlength: "Lütfen geçerli 11 haneli bir TC Kimlik Numarası girin"
                }
            }
        });
        return $form.valid();
    }
    return false;
};

const getFormValues = (formId) => {
    const $form = $(formId);
    const formValues = {};
    $form.find(":input").each(function() {
        const name = $(this).attr("name");
        const value = $(this).val();
        if (name && value) {
            formValues[name] = value;
        }
    });
    return formValues;
};
