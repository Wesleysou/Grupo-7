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

router.get("/getMemoriaRamEmUsoTot2", function (req,res){
       usuarioController.getMemoriaRamEmUsoTot2(req, res)
});

router.get("/getMemoriaRamEmUsoTot3", function (req,res){
       usuarioController.getMemoriaRamEmUsoTot3(req, res)
});

router.get("/getMemoriaRamEmUsoTot4", function (req,res){
       usuarioController.getMemoriaRamEmUsoTot4(req, res)
});

router.get("/getMemoriaRamEmUsoTot5", function (req,res){
       usuarioController.getMemoriaRamEmUsoTot5(req, res)
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

router.get("/getMemoriaRamTotalTot2", function (req,res){
       usuarioController.getMemoriaRamTotalTot2(req, res)
});

router.get("/getMemoriaRamTotalTot3", function (req,res){
       usuarioController.getMemoriaRamTotalTot3(req, res)
});

router.get("/getMemoriaRamTotalTot4", function (req,res){
       usuarioController.getMemoriaRamTotalTot4(req, res)
});

router.get("/getMemoriaRamTotalTot5", function (req,res){
       usuarioController.getMemoriaRamTotalTot5(req, res)
});

//
router.put("/atualizar/:idUsuario", function (req, res) {
       avisoController.atualizar(req, res);
   });

router.post("/reiniciarmaq", function (req, res) {
       usuarioController.reiniciarmaq(req, res);
     });

module.exports = router; 