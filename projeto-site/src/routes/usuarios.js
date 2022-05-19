var express = require("express");
var router = express.Router();

var usuarioController = require("../controllers/usuarioController");

router.get("/", function (req, res) {
    usuarioController.testar(req, res);
});

router.get("/listar", function (req, res) {
    usuarioController.listar(req, res);
});

router.post("/cadastrar", function (req, res) {
    usuarioController.cadastrar(req, res);
})

router.post("/autenticar", function (req, res) {
    usuarioController.entrar(req, res);
});

router.get("/getMemoriaRamTotal", function (req,res){
       usuarioController.getMemoriaRamTotal(req, res)
});

router.get("/getMemoriaRamEmUso", function (req,res){
       usuarioController.getMemoriaRamEmUso(req, res)
});

router.get("/getMemoriaRamEmUsoMaq2", function (req,res){
       usuarioController.getMemoriaRamEmUsoMaq2(req, res)
});

router.get("/getMemoriaRamEmUsoMaq3", function (req,res){
       usuarioController.getMemoriaRamEmUsoMaq3(req, res)
});

router.get("/getMemoriaEmUso", function (req,res){
       usuarioController.getMemoriaEmUso(req, res)
});

router.get("/getMemoriaTotal", function (req,res){
       usuarioController.getMemoriaTotal(req, res)
});

router.get("/getSistemaOp", function (req,res){
       usuarioController.getSistemaOp(req, res)
});

router.get("/getProcessador", function (req,res){
       usuarioController.getProcessador(req, res)
});

router.get("/getArquitetura", function (req,res){
       usuarioController.getArquitetura(req, res)
});

router.get("/getCpu", function (req,res){
       usuarioController.getCpu(req, res)
});

module.exports = router; 