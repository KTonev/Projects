import wx


class BMICalculator(wx.Frame):
    def __init__(self, parent, id):
        wx.Frame.__init__(self, parent, id, "Calculator", (600, 800))
        self.panel = wx.Panel(self)
        self.Centre()
        self.info_text = wx.StaticText(self.panel, -1, "Body Mass Index", (150, 15))
        self.result_text = wx.StaticText(self.panel, -1, "", (150, 50))
        self.error_text = wx.StaticText(self.panel, -1, "", (269, 65))
        self.static_text_weight = wx.StaticText(self.panel, -1, "weight:", (20, 130))
        self.weight = wx.SpinCtrlDouble(self.panel, -1, pos=(65, 127), size=(60, -1), max=3000)
        self.static_text_height = wx.StaticText(self.panel, -1, "height:", (20, 90))
        self.height = wx.SpinCtrlDouble(self.panel, -1, pos=(65, 87), size=(60, -1), max=3000)
        self.button_compute = wx.Button(self.panel, label="Compute", pos=(40, 170), size=(60, -1))
        self.button_compute.Bind(wx.EVT_BUTTON, self.compute_bmi)
        self.button_cancel = wx.Button(self.panel, label="Close", pos=(285, 170), size=(60, -1))
        self.button_cancel.Bind(wx.EVT_BUTTON, self.close)

    def compute_bmi(self, event):
        if self.compute(self.height.GetValue(), self.weight.GetValue()) is None:
            self.result_text.SetLabel("")
        else:
            self.result_text.SetLabel(str(self.compute(self.height.GetValue(), self.weight.GetValue())))

    def close(self, event):
        self.Close(True)

    def error(self):
        self.error_text.SetLabel("Division by zero")

    def compute(self, height, weight):
        self.error_text.SetLabel("")
        height_m = float(height) / 100
        if (height_m * height_m) == 0:
            self.error()
            return None
        result = weight / (height_m * height_m)
        return result


def main():
    app = wx.App()
    frame = BMICalculator(None, -1)
    frame.Show()
    app.MainLoop()


if __name__ == "__main__":
    main()
